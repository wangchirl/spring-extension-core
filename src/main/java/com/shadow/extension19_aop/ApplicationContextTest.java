package com.shadow.extension19_aop;

import com.shadow.extension19_aop.annotation.config.AopConfig;
import com.shadow.extension19_aop.annotation.service.CommonService;
import com.shadow.extension19_aop.xml.service.CalculatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        // 1、Xml 方式
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-19.xml");
        CalculatorService bean = ac.getBean(CalculatorService.class);
        bean.add(1,1);
        bean.show();
        // 2、注解方式
        AnnotationConfigApplicationContext ac1 = new AnnotationConfigApplicationContext(AopConfig.class);
        CommonService service = ac1.getBean(CommonService.class);
        service.say("shadow");
        service.add(1,1);

    }

}
