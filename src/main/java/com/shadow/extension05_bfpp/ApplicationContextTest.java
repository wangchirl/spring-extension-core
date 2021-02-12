package com.shadow.extension05_bfpp;

import com.shadow.extension05_bfpp.test.Cat;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * 1、BFPP 可以对工厂中的 BeanDefinition 进行修改操作
 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-05.xml");
        Cat cat1 = ac.getBean(Cat.class);
        Cat cat2 = ac.getBean(Cat.class);
        ConsolePrinter.printlnCyan(cat1 == cat2); // false
    }

}
