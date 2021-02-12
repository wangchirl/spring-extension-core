package com.shadow.extension10_conversion_service;

import com.shadow.extension10_conversion_service.test.Father;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.TypeDescriptor;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、类型转换器
 *  Converter -> 1 - 1 转换
 *  ConverterFactory -> 1 - N 转换
 *  GenericConverter -> N - N 转换
 * @see org.springframework.core.convert.converter.Converter#convert(Object)
 * @see org.springframework.core.convert.converter.ConverterFactory#getConverter(Class)
 * @see org.springframework.core.convert.converter.GenericConverter#convert(Object, TypeDescriptor, TypeDescriptor)
 *
 * 2、Java 自带的属性编辑器，上面的 Spring 提供的功能更强大
 * @see java.beans.PropertyEditorSupport#setAsText(String)
 * @see com.shadow.extension03_editor_xml
 * @see com.shadow.extension04_editor_annotation
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-10.xml");
        Father bean = ac.getBean(Father.class);
        ConsolePrinter.printlnYellow(bean);
    }

}
