package com.shadow.extension24_condition;

import com.shadow.extension24_condition.ex.CustomerConfig;
import com.shadow.extension24_condition.ex.TestConfig;
import com.shadow.extension24_condition.test.Q;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、条件匹配
 *      @see org.springframework.context.annotation.Condition#matches(ConditionContext, AnnotatedTypeMetadata)
 *      @see org.springframework.context.annotation.Conditional
 *
 *     常用注解：
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnBean
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnClass
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnResource
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication
 *
 *  2、自定义条件
 *      ① 实现接口 Condition 的 matches 方法
 *      @see org.springframework.context.annotation.Condition#matches(ConditionContext, AnnotatedTypeMetadata)
 *      ② 使用注解 @Conditional(value = {xxxCondition.class})
 *      @see org.springframework.context.annotation.Conditional#value()
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、系统自带的 条件
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(TestConfig.class);
        // q w bean 不能同时存在 容器中
        Q q = (Q) ac.getBean("q"); // 存在满足条件
        // W w = (W) ac.getBean("w"); // 不满足条件，报错

        // 2、自定义条件
        AnnotationConfigApplicationContext ac1 = new AnnotationConfigApplicationContext();
        ac1.getEnvironment().setActiveProfiles("dev");
        ac1.register(CustomerConfig.class);
        ac1.refresh();
        Object e = ac1.getBean("e"); // 满足条件 dev 时注入
        // Object q1 = ac1.getBean("q"); // e 注入则 q 不能注入
    }

}
