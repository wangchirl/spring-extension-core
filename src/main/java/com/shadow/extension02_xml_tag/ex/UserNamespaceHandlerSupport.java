package com.shadow.extension02_xml_tag.ex;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class UserNamespaceHandlerSupport extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("xsd-user", new UserBeanDefinitionParser());
    }
}
