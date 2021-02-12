package com.shadow.extension22_import_scan.ex;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;

import java.util.List;
import java.util.Set;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class ShadowBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor , PriorityOrdered {


    private Set<String> packageToScan;

    public ShadowBeanFactoryPostProcessor(Set<String> packageToScan) {
        this.packageToScan = packageToScan;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // scanner
        ShadowBeanScannner scannner = new ShadowBeanScannner(packageToScan);
        List<BeanDefinitionHolder> beanDefinitionHolders = scannner.scan();
        // registry
        registryBeanDefinitions(beanDefinitionHolders, registry);
    }

    private void registryBeanDefinitions(List<BeanDefinitionHolder> beanDefinitionHolders, BeanDefinitionRegistry registry) {
        // do registry
        doRegistryBeanDefinitions(beanDefinitionHolders, registry);
    }

    private void doRegistryBeanDefinitions(List<BeanDefinitionHolder> beanDefinitionHolders, BeanDefinitionRegistry registry) {
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            registry.registerBeanDefinition(beanDefinitionHolder.getBeanName(),beanDefinitionHolder.getBeanDefinition());
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
