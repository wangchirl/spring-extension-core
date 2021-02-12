package com.shadow.extension05_bfpp.ex;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class CustomerBFPP implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 修改 BD 属性值
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("cat");
        beanDefinition.setScope("prototype");
    }
}
