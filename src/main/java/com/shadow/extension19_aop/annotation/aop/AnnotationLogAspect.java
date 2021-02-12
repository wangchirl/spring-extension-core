package com.shadow.extension19_aop.annotation.aop;

import com.shadow.extension19_aop.aspect.LogAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Aspect
@Component
public class AnnotationLogAspect extends LogAspect {

    // Pointcut 切面：感兴趣的连接点
    @Pointcut("execution(public void com.shadow.extension19_aop.annotation.service.CommonServiceImpl.*(..))")
    public void pointcut0(){}

    // Pointcut 切面：感兴趣的连接点
    @Pointcut("@annotation(com.shadow.extension19_aop.annotation.annotation.SysLog)")
    public void pointcut1(){}

    @Override
    @Before(value = "pointcut0()")
    public Object before(JoinPoint joinPoint) {
        return super.before(joinPoint);
    }

    @Override
    @AfterReturning(value = "pointcut0()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        super.afterReturning(joinPoint, result);
    }

    @Override
    @AfterThrowing(value = "pointcut0()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        super.afterThrowing(joinPoint, throwable);
    }

    @Override
    @After(value = "pointcut0()")
    public void after(JoinPoint joinPoint) {
        super.after(joinPoint);
    }

    @Override
    @Around(value = "pointcut1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return super.around(pjp);
    }
}
