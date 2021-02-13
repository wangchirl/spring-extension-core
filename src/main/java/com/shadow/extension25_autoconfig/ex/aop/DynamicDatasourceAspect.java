package com.shadow.extension25_autoconfig.ex.aop;

import com.shadow.extension25_autoconfig.ex.annotation.DynamicDatasource;
import com.shadow.extension25_autoconfig.ex.common.DynamicContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Aspect
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DynamicDatasourceAspect {

    @Pointcut("@annotation(com.shadow.extension25_autoconfig.ex.annotation.DynamicDatasource) " +
            "|| @within(com.shadow.extension25_autoconfig.ex.annotation.DynamicDatasource)")
    public void datasourcePointcut(){}

    @Around("datasourcePointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Class<?> targetClass = pjp.getTarget().getClass(); // 目标类
        Method targetMethod = signature.getMethod(); // 目标方法
        log.debug("target method ===> {}", targetMethod);
        // 1、先获取类上面的注解信息
        DynamicDatasource classAnnotation = targetClass.getAnnotation(DynamicDatasource.class);
        // 2、再获取方法上的注解信息
        DynamicDatasource methodAnnotation = targetMethod.getAnnotation(DynamicDatasource.class);
        // 3、确认最终的数据源，最小粒度的是方法级别的
        if(classAnnotation != null || methodAnnotation != null) {
            String value;
            if(methodAnnotation != null) {
                value = methodAnnotation.value();
            } else {
                value = classAnnotation.value();
            }
            // ThreadLocal 线程共享变量设置
            DynamicContextHolder.push(value);
            log.debug("set datasource is {}" , value);
        }
        try {
            // 真正执行的方法
            return pjp.proceed();
        } finally {
            // 清空线程共享变量及ThreadLocal对象
            DynamicContextHolder.poll();
            log.debug("clean datasource");
        }
    }

}
