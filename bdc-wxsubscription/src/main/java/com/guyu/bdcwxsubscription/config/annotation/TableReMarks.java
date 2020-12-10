package com.guyu.bdcwxsubscription.config.annotation;

import java.lang.annotation.*;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/10 0010 12:28
 * @描述 表备注注解
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableReMarks {
    String value() default ""; //表备注
}
