package com.guyu.bdcwxsubscription.config;

import com.guyu.bdcwxsubscription.entity.WxLogsEntity;
import com.guyu.bdcwxsubscription.config.annotation.OperateLog;
import com.guyu.bdcwxsubscription.service.WxLogsService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/6 0006 10:13
 * @描述 日志切面拦截
 **/
@Aspect
@Component
@Slf4j
@SuppressWarnings("all")
public class OperateLogAspect {
    //注入Service用于把日志保存数据库
    @Autowired
    private WxLogsService logsService;

    // 切入点
    @Pointcut(value = "@annotation(com.guyu.bdcwxsubscription.config.annotation.OperateLog)")
    private void pointcut() {
    }

    /**
     * <p>Discription:[后置通知，扫描com.guyu.controller包及此包下的所有带有operateLog注解的方法]</p>
     * Created on 2020-12-6 上午10:28:34
     * @param point 前置参数
     * @param operateLog 自定义注解
     * @author:[黄盼]
     */
//    @Around(value = "pointcut() && @annotation(operateLog)")
//    public Object doAfterAdvice(ProceedingJoinPoint point, OperateLog operateLog) {
//        System.out.println("++++执行了around方法++++");
//        String name = operateLog.moduleName();
//        Integer type=operateLog.methodType();
//        // 拦截的类名
//        Class clazz = point.getTarget().getClass();
//        // 拦截的方法
//        Signature sig = point.getSignature();
//        MethodSignature msig = null;
//        if (!(sig instanceof MethodSignature)) {
//            throw new IllegalArgumentException("该注解只能用于方法");
//        }
//        msig = (MethodSignature) sig;
//        Object target = point.getTarget();
//        Method currentMethod;
//        try {
//            currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
//            System.out.println("执行了类:" + clazz.getSimpleName());
//            System.out.println("方法:" + currentMethod.getName());
//            System.out.println("自定义注解:" + name);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            return point.proceed(); // 执行程序
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            return throwable.getMessage();
//        }
//    }

    /**
     * 方法执行后
     *
     * @param joinPoint
     * @param result
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(operateLog)", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, OperateLog operateLog, Object result) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        WxLogsEntity systemLog = new WxLogsEntity();
        //当前操作人信息
        systemLog.setLogContent(operateLog.moduleName());
        systemLog.setRequestWeb(getWebInfo(request));
        systemLog.setRequestUrl(request.getRequestURI());
        systemLog.setRequestIp(getRequestIP());
        logsService.save(systemLog);
        return result;
    }

    /**
     * 方法执行后 并抛出异常
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(operateLog)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, OperateLog operateLog, Exception ex) {
        System.out.println("++++执行了afterThrowing方法++++");
        System.out.println("请求：" + operateLog.moduleName() + " 出现异常:" + ex.getMessage());
    }

    /**
     * 获取当前请求的IP,对使用代理后都有效
     *
     * @return
     */
    public static String getRequestIP() {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取当前浏览器以及设备信息
     *
     * @return
     */
    public static String getWebInfo(HttpServletRequest request) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        return "浏览器" + browser.getName();
    }

}
