package com.shadow.extension21_import;

import com.shadow.extension21_import.ex.config.Config;
import com.shadow.extension21_import.test.Account;
import com.shadow.extension21_import.test.MMapper;
import com.shadow.extension21_import.test.NMapper;
import com.shadow.extension21_import.test.NormalEntity;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、@Import 注解：注册类到 IOC 容器
 *    ① 普通的 class，容器会自动注册这个类，id 默认全类名
 *    ② ImportSelector 接口，注册一批 class
 *      @see org.springframework.context.annotation.ImportSelector#selectImports(AnnotationMetadata)
 *    ③ ImportBeanDefinitionRegistrar 一般结合扫描注解使用
 *      @see org.springframework.context.annotation.ImportBeanDefinitionRegistrar#registerBeanDefinitions(AnnotationMetadata, BeanDefinitionRegistry)
 *      接口方法参数 AnnotationMetadata,它可以获取当前类（被@Import标记）的注解消息，它使用标准的反射来获取指定类的内部注解消息
 *      @see AnnotationMetadata#getAnnotationTypes()
 *      案例：Mybatis mapper 扫描
 *      @see org.mybatis.spring.annotation.MapperScannerRegistrar
 *
 *   特别说明：ImportSelector，ImportBeanDefinitionRegistrar 实现类均可实现以下接口作为扩展需要，注入需要的属性
 *      @see org.springframework.context.EnvironmentAware#setEnvironment(Environment)
 *      @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(BeanFactory)
 *      @see org.springframework.beans.factory.BeanClassLoaderAware#setBeanClassLoader(ClassLoader)
 *      @see org.springframework.context.ResourceLoaderAware#setResourceLoader(ResourceLoader)
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Account account = ac.getBean(Account.class);

        NMapper nMapper = (NMapper) ac.getBean("nMapper");
        MMapper mMapper = (MMapper) ac.getBean("mMapper");

        NormalEntity normal = (NormalEntity) ac.getBean("com.shadow.extension21_import.test.NormalEntity");
        ConsolePrinter.printlnYellow(account);
        ConsolePrinter.printlnYellow(nMapper);
        ConsolePrinter.printlnYellow(mMapper);
        ConsolePrinter.printlnYellow(normal);
    }

}
