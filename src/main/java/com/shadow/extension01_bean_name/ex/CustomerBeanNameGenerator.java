package com.shadow.extension01_bean_name.ex;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class CustomerBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {
        String beanClassName = beanDefinition.getBeanClassName();
        assert beanClassName != null;
        beanClassName = beanClassName.substring(beanClassName.lastIndexOf(".") + 1);
        beanClassName = beanClassName.substring(0,1).toLowerCase() + beanClassName.substring(1);
        beanClassName = beanClassName + "##";
        return beanClassName;
    }
}
