package com.shadow.extension11_depends_on;

import com.shadow.extension11_depends_on.ex.DependsOnConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * 1、依赖对象
 * @see org.springframework.context.annotation.DependsOn
 *
 * 实例化某个对象时，需要另外一个类型的对象先创建
 * 比如：实例化 JdbcTemplate 对象时，需要先创建好 DataSource 对象
 * @see org.springframework.jdbc.core.JdbcTemplate
 * @see javax.sql.DataSource
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、Xml 版本 depends-on
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-11.xml");
        // 2、注解版 @DependsOn
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DependsOnConfig.class);
    }

}
