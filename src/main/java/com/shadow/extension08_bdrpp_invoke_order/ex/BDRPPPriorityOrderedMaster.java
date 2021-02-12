package com.shadow.extension08_bdrpp_invoke_order.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class BDRPPPriorityOrderedMaster implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ConsolePrinter.printlnRed("【PriorityOrdered】 BDRPP registry Ordered BDRPP");
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(BDRPPOrderedMaster.class);
        beanDefinitionRegistry.registerBeanDefinition(BDRPPOrderedMaster.class.getName(),beanDefinitionBuilder.getBeanDefinition());
        ConsolePrinter.printlnCyan("【priorityOrdered】 BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ConsolePrinter.printlnPurple("【priorityOrdered】 BeanDefinitionRegistryPostProcessor#postProcessBeanFactory");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
