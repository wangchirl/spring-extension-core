package com.shadow.extension19_aop.aspect;

import com.shadow.utils.ConsolePrinter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class LogAspect {

    // 前置通知 Before
    public Object before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        ConsolePrinter.printlnRed("before advise ===> " + signature.getName() + " args = "+ Arrays.toString(args));
        return 100;
    }

    // 返回通知 AfterReturning
    public void afterReturning(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        ConsolePrinter.printlnRed("after returning advise ===> " + signature.getName() + " result = " + result);
    }

    // 异常通知 AfterThrowing
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        Signature signature = joinPoint.getSignature();
        ConsolePrinter.printlnRed("after throwing advise ===> " + signature.getName() + " exception = " + throwable.getMessage());
    }

    // 后置通知 After
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        ConsolePrinter.printlnRed("after advise ===> " + signature.getName());
    }

    // 环绕通知 Around
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Signature signature = pjp.getSignature();
        Object[] args = pjp.getArgs();
        Object res = null;
        try {
            ConsolePrinter.printlnRed("around advise before ===> " + signature.getName() + " args = " + Arrays.toString(args));
            // 执行方法
            res = pjp.proceed();
            ConsolePrinter.printlnRed("around advise after ===> " + signature.getName() + " args = " + Arrays.toString(args));
        } catch (Throwable e) {
            ConsolePrinter.printlnRed("around advise exception ===> " + signature.getName() + "exception = " + e.getMessage());
            throw e;
        } finally {
            ConsolePrinter.printlnRed("around advise finally ===> " + signature.getName() + " result = " + res);
        }
        return res;
    }
}
