package com.guyu.bdcwxsubscription.controller.base;


import com.baomidou.mybatisplus.extension.api.R;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guyu.bdcwxsubscription.config.OperateLogAspect;
import com.guyu.bdcwxsubscription.config.annotation.TableReMarks;
import com.guyu.bdcwxsubscription.entity.WxLogsEntity;
import com.guyu.bdcwxsubscription.service.WxLogsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/10 0010 11:07
 * @描述 公用controller
 * 所有单表的增删改无需通过代码编写
 **/
@Slf4j
@Validated
public class BaseController<S extends IService<T>, T> {
    private static String ADD = "添加";
    private static String UPDATE = "修改";
    private static String DEL = "删除";
    @Autowired
    protected S baseService;
    @Autowired
    private WxLogsService wxLogsService;

    @PostMapping("/add")
    public R insert(@RequestBody @Valid T entity, HttpServletRequest request) {
        boolean issave = baseService.save(entity);
        if (issave) {
            TableReMarks annotation = entity.getClass().getAnnotation(TableReMarks.class);
            addLogs(annotation.value() + ADD, request);
        }
        return R.ok(issave);
    }

    @PostMapping("/update")
    public R update(@RequestBody @Valid T entity, HttpServletRequest request) {
        boolean isedit = baseService.updateById(entity);
        if (isedit) {
            TableReMarks annotation = entity.getClass().getAnnotation(TableReMarks.class);
            addLogs(annotation.value() + UPDATE, request);
        }
        return R.ok(isedit);
    }

    @GetMapping("/del")
    public R delete(T entity, HttpServletRequest request) {
        boolean isdel = baseService.removeById(getId(entity));
        if (isdel) {
            TableReMarks annotation = entity.getClass().getAnnotation(TableReMarks.class);
            addLogs(annotation.value() + DEL, request);
        }
        return R.ok(isdel);
    }

    @GetMapping("/getById")
    public R getById(@NotNull(message = "id不能为空") Long id) {
        return R.ok(baseService.getById(id));
    }

    /**
     * 添加日志
     *
     * @param optionName 操作名称
     * @param request    请求对象
     * @return
     */
    private boolean addLogs(String optionName, HttpServletRequest request) {
        WxLogsEntity systemLog = new WxLogsEntity();
        systemLog.setLogContent(optionName);
        systemLog.setRequestWeb(OperateLogAspect.getWebInfo(request));
        systemLog.setRequestUrl(request.getRequestURI());
        systemLog.setRequestIp(OperateLogAspect.getRequestIP());
        return wxLogsService.save(systemLog);
    }

    /**
     * 通过反射获取id
     *
     * @param t
     * @return
     * @throws Exception
     */
    public Long getId(T t) {
        try {
            String fieldName = "id";
            //通过字符串的变化拼接处getName，即获取name的get方法
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method = t.getClass().getMethod(methodName);
            Object object = method.invoke(t);
            if (StringUtils.isBlank(object.toString())) {
                throw new RuntimeException("id不能为空！");
            }
            return Long.valueOf(object.toString());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
