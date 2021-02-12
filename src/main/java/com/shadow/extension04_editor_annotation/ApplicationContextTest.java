package com.shadow.extension04_editor_annotation;

import com.shadow.extension04_editor_annotation.config.CustomerConfiguration;
import com.shadow.extension04_editor_annotation.test.Human;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
 * 3、@Configuration - 配置类
 *
 * 4、@PropertySource - 读取配置文件
 *
 * 5、@Bean - 注入对象到 IOC 容器
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(CustomerConfiguration.class);
        Human bean = ac.getBean(Human.class);
        ConsolePrinter.printlnCyan(bean);
    }

}
