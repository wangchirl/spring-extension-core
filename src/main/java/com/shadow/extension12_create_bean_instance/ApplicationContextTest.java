package com.shadow.extension12_create_bean_instance;

import com.shadow.extension12_create_bean_instance.config.InstantiationConfig;
import com.shadow.extension12_create_bean_instance.config.SupplierConfig;
import com.shadow.extension12_create_bean_instance.ex.first_instantiation.MyInstantiationAwareBeanPostProcessor;
import com.shadow.extension12_create_bean_instance.test.BeforeInstantiation;
import com.shadow.extension12_create_bean_instance.test.SupplierInstantiation;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.function.Supplier;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * 1、允许提前创建 bean 对象
 *  ① InstantiationAwareBeanPostProcessor -> BPP 的子接口
 * @see InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation(Class, String)
 *  ② Supplier
 * @see Supplier
 * @see org.springframework.beans.factory.support.AbstractBeanDefinition#setInstanceSupplier(Supplier)
 *  ③ FactoryMethod or StaticFactoryMethod 工厂方法或静态工厂方法 factory-method、factory-bean
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        /**
         * 1、InstantiationAwareBeanPostProcessor Xml版
         * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
          */
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-12-1-instantiation.xml");
        BeforeInstantiation bean = ac.getBean(BeforeInstantiation.class);
        bean.dosomething();

        /**
         * 1、InstantiationAwareBeanPostProcessor 注解版
         * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
         */
        AnnotationConfigApplicationContext ac1 =
                new AnnotationConfigApplicationContext(InstantiationConfig.class);
        BeforeInstantiation bean1 = ac1.getBean(BeforeInstantiation.class);
        bean1.dosomething();

        /**
         * 2、Supplier Xml版
         * @see java.util.function.Supplier
         * @see org.springframework.beans.factory.support.GenericBeanDefinition#setInstanceSupplier(Supplier)
         */
        ClassPathXmlApplicationContext ac2 =
                new ClassPathXmlApplicationContext("classpath:config/extension-12-2-supplier.xml");
        SupplierInstantiation bean2 = ac2.getBean(SupplierInstantiation.class);
        ConsolePrinter.printlnCyan(bean2);

        /**
         * 2、Supplier 注解版
         */
        AnnotationConfigApplicationContext ac3 =
                new AnnotationConfigApplicationContext();
        ac3.register(SupplierInstantiation.class);
        ac3.register(SupplierConfig.class);
        ac3.refresh();
        SupplierInstantiation bean3 = ac3.getBean(SupplierInstantiation.class);
        ConsolePrinter.printlnYellow(bean3);

        /**
         * 3、工厂方法 Xml版
         * factory-method
         */
        ClassPathXmlApplicationContext ac4 =
                new ClassPathXmlApplicationContext("classpath:config/extension-12-3-factorymethod.xml");
        Object bean4 = ac4.getBean("factoryInstantiation1");
        Object bean5 = ac4.getBean("factoryInstantiation2");
        ConsolePrinter.printlnRed(bean4);
        ConsolePrinter.printlnRed(bean5);
    }

}
