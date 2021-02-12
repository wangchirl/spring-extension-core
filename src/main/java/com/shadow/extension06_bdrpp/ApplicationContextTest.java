package com.shadow.extension06_bdrpp;

import com.shadow.extension06_bdrpp.test.Dog;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * 1、BDRPP 可以往工厂中注入新的 BD 对象
 * 2、BFPP 可以修改工厂中的 BD
 * @see org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry)
 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-06.xml");
        Dog dog1 = ac.getBean(Dog.class);
        Dog dog2 = ac.getBean(Dog.class);
        ConsolePrinter.printlnCyan(dog1 == dog2); // false
    }

}
