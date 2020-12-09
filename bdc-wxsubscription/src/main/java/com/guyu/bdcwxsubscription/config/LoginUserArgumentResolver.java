package com.guyu.bdcwxsubscription.config;


import com.guyu.bdcwxsubscription.entity.WxPersonnelEntity;
import com.guyu.bdcwxsubscription.config.annotation.LoginUser;
import com.guyu.bdcwxsubscription.service.WxPersonnelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Method;


/**
 * @创建人 黄盼
 * @创建时间 2020/12/8 0008 9:30
 * @描述 注解获取当前登录用户
 **/
@Slf4j
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private WxPersonnelService userService;

    public LoginUserArgumentResolver() {

    }

    public LoginUserArgumentResolver(WxPersonnelService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        final Method method = parameter.getMethod();
        final Class<?> clazz = parameter.getMethod().getDeclaringClass();
        boolean hasParameterAnnotation = parameter.hasParameterAnnotation(LoginUser.class);

        boolean isHasLoginAuth = clazz.isAnnotationPresent(LoginUser.class) || method.isAnnotationPresent(LoginUser.class) || hasParameterAnnotation;
        boolean isHasLoginUserParameter = parameter.getParameterType().isAssignableFrom(WxPersonnelEntity.class);

        return isHasLoginAuth && isHasLoginUserParameter;

    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return getUser();
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public WxPersonnelEntity getUser() {
        WxPersonnelEntity user = userService.getUser();
        return user;
    }
}
