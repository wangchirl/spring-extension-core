package com.shadow.extension01_bean_name;

import com.shadow.extension01_bean_name.test.TController;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * 1、自定义 beanName 生成器
 *
 * @see org.springframework.beans.factory.support.BeanNameGenerator#generateBeanName(BeanDefinition, BeanDefinitionRegistry)
 * @see org.springframework.beans.factory.support.DefaultBeanNameGenerator
 * @see org.springframework.context.annotation.AnnotationBeanNameGenerator
 * @see org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-01.xml");
        TController bean = (TController) ac.getBean("tController##");
        ConsolePrinter.printlnCyan(bean.toString());
    }

}
