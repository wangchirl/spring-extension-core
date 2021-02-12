package com.shadow.extension08_bdrpp_invoke_order.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class BDRPPOrderedMaster implements BeanDefinitionRegistryPostProcessor, Ordered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ConsolePrinter.printlnRed("【Ordered】 BDRPP registry NoOrdered BDRPP");
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(BDRPPNoOrderedMaster.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition(BDRPPNoOrderedMaster.class.getName(), beanDefinition);
        ConsolePrinter.printlnCyan("【ordered】 BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ConsolePrinter.printlnPurple("【ordered】 BeanDefinitionRegistryPostProcessor#postProcessBeanFactory");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
