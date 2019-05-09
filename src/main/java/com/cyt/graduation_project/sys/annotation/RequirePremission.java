package com.cyt.graduation_project.sys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 是一个权限控制注解，配置拦截器使用
 */

@Target(ElementType.METHOD) //指定注解可以添加的位置
@Retention(RetentionPolicy.RUNTIME)

public @interface RequirePremission {
    String value() default "";
}
