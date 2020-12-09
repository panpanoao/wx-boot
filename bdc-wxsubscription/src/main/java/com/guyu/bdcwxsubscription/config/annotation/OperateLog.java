package com.guyu.bdcwxsubscription.config.annotation;
import java.lang.annotation.*;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/6 0006 10:11
 * @描述  日志注解
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OperateLog {

    /**
     * 要执行的操作名称
     **/
    String moduleName() default "";
}
