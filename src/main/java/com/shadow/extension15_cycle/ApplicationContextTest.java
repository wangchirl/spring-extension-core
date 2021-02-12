package com.shadow.extension15_cycle;

import com.shadow.extension15_cycle.config.CycleConfig;
import com.shadow.extension15_cycle.test.A;
import com.shadow.extension15_cycle.test.AA;
import com.shadow.extension15_cycle.test.B;
import com.shadow.extension15_cycle.test.BB;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、循环依赖
 *      Spring 通过三级缓存来解决循环依赖问题：
 *      其实解决循环依赖问题是要二级缓存就可以了，为什么 Spring 要使用三级缓存呢？
 *  @see org.springframework.beans.factory.support.DefaultListableBeanFactory
 *  ① singletonObjects      -> 一级缓存
 *  ② earlySingletonObjects -> 二级缓存
 *  ③ singletonFactories    -> 三级缓存
 *
 *  提前暴露创建后但未完全创建完成的 bean 对象
 *  @see org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor#getEarlyBeanReference(Object, String)
 *
 *  使用三级缓存的目的是为了能够对 bean 进行代理
 *  @see org.springframework.beans.factory.ObjectFactory#getObject
 *
 *  对比 FactoryBean
 *  @see org.springframework.beans.factory.FactoryBean#getObject
 *
 *  2、可以关闭循环依赖
 * @see AnnotationConfigApplicationContext#setAllowCircularReferences(boolean)
 * @see ClassPathXmlApplicationContext#setAllowCircularReferences(boolean)
 * @see org.springframework.context.support.AbstractXmlApplicationContext#setAllowCircularReferences(boolean)
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、Xml 方式
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-15.xml");
        A a = ac.getBean(A.class);
        B b = ac.getBean(B.class);
        ConsolePrinter.printlnRed(a.getB() == b);

        // 2、注解方式
        AnnotationConfigApplicationContext ac1 =
                new AnnotationConfigApplicationContext(CycleConfig.class);
        AA aa = ac1.getBean(AA.class);
        BB bb = ac1.getBean(BB.class);
        ConsolePrinter.printlnYellow(aa.bb == bb);

        // 3、关闭循环依赖支持 - 会报错
        AnnotationConfigApplicationContext ac2 =
                new AnnotationConfigApplicationContext();
        ac2.register(CycleConfig.class);
        // 关闭循环依赖支持
        ac2.setAllowCircularReferences(false);
        ac2.refresh();

    }

}
