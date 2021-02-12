package com.shadow.extension17_factory_bean;

import com.shadow.extension17_factory_bean.ex.MyFactoryBean;
import com.shadow.extension17_factory_bean.test.User;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、BeanFactory bean 工厂 IOC 容器
 *      ① 存放 BeanDefinition 的容器 beanDefinitionMap
 *      ② 存放单例的容器 singletonObjects
 *      ③ 创建管理 bean 的容器
 *
 *  2、FactoryBean 工厂 bean
 *      ① FactoryBean 对象也有 BeanFactory 工厂来管理
 *      ② FactoryBean 可以通过其 getObject 方法生产对象
 *      ③ 直接根据 beanName 获取的对象是其 getObject 方法生产的对象
 *      ④ 如果想获取 FactoryBean 对象的话，需要在 beanName 前拼接上取地址符 &
 *      ⑤ FactoryBean 通常来实现对象代理
 *  @see org.mybatis.spring.mapper.MapperFactoryBean     -> Mybatis
 *  @see org.apache.dubbo.config.spring.ReferenceBean    -> Dubbo
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-17.xml");
        User user = (User) ac.getBean("user"); // 获取 FactoryBean 实际生产的对象
        ConsolePrinter.printlnYellow(user);
        User user1 = (User) ac.getBean("user"); // 获取 FactoryBean 实际生产的对象
        ConsolePrinter.printlnRed(user == user1); // isSingleton 方法决定是否单例
        MyFactoryBean factoryBean = (MyFactoryBean) ac.getBean("&user"); // 获取 FactoryBean 对象本身
        ConsolePrinter.printlnRed(factoryBean);

    }

}
