package com.shadow.extension08_bdrpp_invoke_order.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class ManualAddBDRPPNoOrdered implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ConsolePrinter.printlnCyan("【manual add noOrdered】BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ConsolePrinter.printlnPurple("【manual add noOrdered】BeanDefinitionRegistryPostProcessor#postProcessBeanFactory");
    }
}
