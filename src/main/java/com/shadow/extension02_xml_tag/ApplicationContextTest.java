package com.shadow.extension02_xml_tag;

import com.shadow.extension02_xml_tag.test.User;
import com.shadow.extension02_xml_tag.test.UserController;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * 1、BeanDefinition 解析器
 * @see org.springframework.beans.factory.xml.BeanDefinitionParser
 * @see org.springframework.beans.factory.xml.AbstractBeanDefinitionParser
 * @see org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser
 * @see org.apache.dubbo.config.spring.schema.AnnotationBeanDefinitionParser
 * @see org.springframework.context.annotation.AnnotationConfigBeanDefinitionParser
 *
 * 案例：
 *   ① Dubbo 自定义 Xml 标签解析器
 *      @see org.apache.dubbo.config.spring.schema.DubboBeanDefinitionParser
 *   ② Mybatis 自定义 Xml 标签解析器
 *      @see org.mybatis.spring.config.MapperScannerBeanDefinitionParser
 *
 * 2、.xsd 文件
 *
 * 3、META-INF/spring.schemas
 *
 * 4、META-INF/spring.handlers
 *      @see org.springframework.beans.factory.xml.NamespaceHandler#init()
 *      @see org.springframework.beans.factory.xml.NamespaceHandlerSupport#init()
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-02.xml");
        UserController bean = (UserController) ac.getBean(UserController.class);
        User user = (User) ac.getBean(User.class);
        ConsolePrinter.printlnCyan(user.getUserName());
        ConsolePrinter.printlnCyan(user.getEmail());
        ConsolePrinter.printlnCyan(user.getPassword());
    }

}
