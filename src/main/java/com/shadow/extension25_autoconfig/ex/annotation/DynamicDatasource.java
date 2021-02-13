package com.shadow.extension25_autoconfig.ex.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicDatasource {

    /**
     * 多数据源名称配置
     * @return
     */
    String value();

    /**
     * 数据库描述
     * @return
     */
    String describe() default "";
}
