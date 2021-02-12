package com.shadow.extension18_proxy_jdk_cglib;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:config/extension-01.xml");
    }

}
