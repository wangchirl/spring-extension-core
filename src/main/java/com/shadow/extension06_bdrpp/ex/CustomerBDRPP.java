package com.shadow.extension06_bdrpp.ex;

import com.shadow.extension06_bdrpp.test.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class CustomerBDRPP implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        // 注入新的 BD 到工厂中
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Dog.class);
        builder.addPropertyValue("name", "小黑").addPropertyValue("age",3);
        beanDefinitionRegistry.registerBeanDefinition("dog", builder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 修改 BD 的属性值
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("dog");
        beanDefinition.setScope("prototype");
    }
}
