package com.shadow.extension03_editor_xml;

import com.shadow.extension03_editor_xml.test.Person;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * 1、属性编辑器
 * @see java.beans.PropertyEditorSupport#setAsText(String)
 * @see org.springframework.beans.PropertyEditorRegistrar#registerCustomEditors(PropertyEditorRegistry)
 *
 * 2、注入 IOC 容器
 * @see org.springframework.beans.factory.config.CustomEditorConfigurer#setPropertyEditorRegistrars(PropertyEditorRegistrar[])
 * @see org.springframework.beans.factory.config.CustomEditorConfigurer#setCustomEditors(Map)
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-03.xml");
        Person bean = ac.getBean(Person.class);
        ConsolePrinter.printlnCyan(bean);
    }

}
