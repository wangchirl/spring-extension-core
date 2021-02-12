package com.shadow.extension08_bdrpp_invoke_order.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class ManualAddBDRPPOrdered implements BeanDefinitionRegistryPostProcessor, Ordered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ConsolePrinter.printlnCyan("【manual add Ordered】BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ConsolePrinter.printlnPurple("【manual add Ordered】BeanDefinitionRegistryPostProcessor#postProcessBeanFactory");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
