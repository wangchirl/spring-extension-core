package com.shadow.extension13_method_override;

import com.shadow.extension13_method_override.config.ScanConfig;
import com.shadow.extension13_method_override.ex.lookup.Person;
import com.shadow.extension13_method_override.ex.lookup.SingletonObj;
import com.shadow.extension13_method_override.ex.replace.OriginObj;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、lookup-method
 *      Spring 中默认的对象是单例的，Spring 会在一级缓存中持有该对象，方便下次直接获取
 *      那么如果是原型作用域的话，会创建一个新的对象
 *
 *      如果想在一个单例 bean 中引用一个原型的 bean 的话，怎么办呢?
 *      此时就需要引用 lookup-method 标签来解决此问题
 *      @see org.springframework.beans.factory.annotation.Lookup
 *
 *      通过拦截器的方式每次需要的时候都去创建新的对象，而不是把原型对象缓存起来
 *      <lookup-method></lookup-method> xml 标签
 *
 *  2、replace-method
 *      @see org.springframework.beans.factory.support.MethodReplacer
 *      <replace-method></replace-method>
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、xml 失败的方式
        ClassPathXmlApplicationContext ac0 =
                new ClassPathXmlApplicationContext("classpath:config/extension-13-lookup-fail.xml");
        Person p = ac0.getBean(Person.class);
        Person p0 = ac0.getBean(Person.class);
        ConsolePrinter.printlnYellow(p.getCar() == p0.getCar());

        // 2、xml 成功的方式 lookup-method
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-13-lookup-success.xml");
        Person p1 = ac.getBean(Person.class);
        Person p2 = ac.getBean(Person.class);
        ConsolePrinter.printlnYellow(p1.getCar() == p2.getCar());

        // 3、注解方式实现 @Lookup
        AnnotationConfigApplicationContext ac1 =
                new AnnotationConfigApplicationContext(ScanConfig.class);
        SingletonObj bean1 = ac1.getBean(SingletonObj.class);
        SingletonObj bean2 = ac1.getBean(SingletonObj.class);
        bean1.dosomething();
        bean2.dosomething();
        ConsolePrinter.printlnYellow(bean1.protoTypeObj() == bean2.protoTypeObj());

        // 4、replace-method
        ClassPathXmlApplicationContext ac2 =
                new ClassPathXmlApplicationContext("classpath:config/extension-13-replace.xml");
        OriginObj bean = ac2.getBean(OriginObj.class);
        bean.say();
        bean.say("shadow");
        bean.say("shadow",20);
    }

}
