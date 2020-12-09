package com.guyu.bdcwxsubscription.config;

import com.guyu.bdcwxsubscription.entity.WxPersonnelEntity;
import com.guyu.bdcwxsubscription.constant.CommonParameters;
import com.guyu.bdcwxsubscription.utils.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/7 0007 10:23
 * @描述 设置登录拦截
 **/
@Component
@Slf4j
public class LoginInterceptor implements  HandlerInterceptor {

    @Autowired
    private RedisCache redisCache;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        WxPersonnelEntity personnel = redisCache.getCacheObject(CommonParameters.LOGIN);
        if (personnel == null) {
            httpServletResponse.sendRedirect("/login.html");
            //跳转登录页
            return false;
        }
        return true;

    }


}
