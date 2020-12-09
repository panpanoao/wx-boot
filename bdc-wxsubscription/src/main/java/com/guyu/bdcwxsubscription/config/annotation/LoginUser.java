package com.guyu.bdcwxsubscription.config.annotation;

import java.lang.annotation.*;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/8 0008 9:27
 * @描述 登录注解
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
public @interface LoginUser {

}
