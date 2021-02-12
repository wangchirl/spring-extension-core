package com.shadow.extension09_bpp_registry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * @see org.springframework.beans.factory.config.BeanPostProcessor -> bean 初始化前后干点事
 * 1、注册 BPP 到工厂中的 beanPostProcessors 集合中
 *   ① 首先将实现了 PriorityOrdered 接口的 BPP 实例化并 add 到 beanPostProcessors 集合中
 *   ② 再将实现了 Ordered 接口的 BPP 实例化并 add 到 beanPostProcessors 集合中
 *   ③ 然后将未实现上面2个接口的 BPP 实例化并 add 到 beanPostProcessors 集合中
 *   ④ 最后将 Spring 内部的 BPP 实例化并 add 到 beanPostProcessors 集合中
 *
 * 2、BeanPostProcessor 子接口及其作用
 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor -> bean实例化前后干点事
 * @see org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor -> bean 循环依赖问题
 * @see org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor -> 允许在实例化 bean 后修改 BeanDefinition
 * @see org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor -> bean 对象销毁前干点事
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 按照 PriorityOrdered -> Ordered -> NoOrdered 顺序实例化并存入到工厂中
        // beanPostProcessors 变量接收
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-09.xml");
    }

}
