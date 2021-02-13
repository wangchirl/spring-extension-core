package com.shadow.extension19_aop;

import com.shadow.extension19_aop.annotation.config.AopConfig;
import com.shadow.extension19_aop.annotation.service.CommonService;
import com.shadow.extension19_aop.xml.service.CalculatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、AOP 切面编程 -> OOP 补充
 *      ① 切面 Aspect -> 自定义
 *      ② 连接点 JoinPoint -> Spring 中的连接点泛指方法
 *      ③ 通知 Advise
 *          @see org.springframework.aop.aspectj.AspectJMethodBeforeAdvice -> 前置通知
 *          @see org.springframework.aop.aspectj.AspectJAfterAdvice -> 后置通知
 *          @see org.springframework.aop.aspectj.AspectJAfterReturningAdvice -> 返回通知
 *          @see org.springframework.aop.aspectj.AspectJAfterThrowingAdvice -> 异常通知
 *          @see org.springframework.aop.aspectj.AspectJAroundAdvice -> 环绕通知
 *
 *      通知注解：
 *          @see org.aspectj.lang.annotation.Before
 *          @see org.aspectj.lang.annotation.After
 *          @see org.aspectj.lang.annotation.AfterReturning
 *          @see org.aspectj.lang.annotation.AfterThrowing
 *          @see org.aspectj.lang.annotation.Around
 *
 *      ④ 切点 Pointcut
 *          @see org.springframework.aop.Pointcut
 *          @see org.springframework.aop.aspectj.AspectJExpressionPointcut
 *
 *      ⑤ 通知器 Advisor 对 Advise 和 Pointcut 的包装
 *          @see org.springframework.aop.aspectj.AspectJPointcutAdvisor
 *          @see org.springframework.aop.aspectj.AspectJPointcutAdvisor#advice
 *          @see org.springframework.aop.aspectj.AspectJPointcutAdvisor#pointcut
 *
 *          在执行过程中通知器其实是在一个链中的，其链开始的是 ExposeInvocationInterceptor
 *          @see org.springframework.aop.interceptor.ExposeInvocationInterceptor
 *
 *  2、通知实现的分类：
 *      @see org.aopalliance.intercept.MethodInterceptor
 *      @see org.springframework.aop.aspectj.AspectJAfterAdvice
 *      @see org.springframework.aop.aspectj.AspectJAfterThrowingAdvice
 *      @see org.springframework.aop.aspectj.AspectJAroundAdvice
 *
 *  3、Xml 方式的通知器在执行过程中与在 Xml 配置的先后顺序有关（取的是配置顺序的下标顺序：Before - Around、After - Around）
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、Xml 方式
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-19.xml");
        CalculatorService bean = ac.getBean(CalculatorService.class);
        bean.add(1,1);
        bean.show();
        // 2、注解方式
        AnnotationConfigApplicationContext ac1 = new AnnotationConfigApplicationContext(AopConfig.class);
        CommonService service = ac1.getBean(CommonService.class);
        service.say("shadow");
        service.add(1,1);

    }

}
