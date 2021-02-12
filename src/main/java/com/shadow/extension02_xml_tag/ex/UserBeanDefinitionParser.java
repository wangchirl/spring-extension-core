package com.shadow.extension02_xml_tag.ex;

import com.shadow.extension02_xml_tag.test.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class UserBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        // 获取标签具体的属性值
        // 对应 user.xsd 文件中的属性名称
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        String password = element.getAttribute("password");
        if(StringUtils.hasText(userName)) {
            builder.addPropertyValue("userName", userName);
        }
        if(StringUtils.hasText(email)) {
            builder.addPropertyValue("email", email);
        }
        if(StringUtils.hasText(password)) {
            builder.addPropertyValue("password", password);
        }
    }
}
