package com.shadow.extension14_populate;

import com.shadow.extension14_populate.test.Man;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、属性填充
 *  <property></property>
 *  <array></array> -> 数组对象
 *  <list></list>   -> list 集合对象
 *  <set></set>     -> set 集合对象
 *  <map></map>     -> map 集合对象
 *  <props></props> -> Properties 对象
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-14.xml");
        Man bean = ac.getBean(Man.class);
        ConsolePrinter.printlnRed(bean);
    }

}
