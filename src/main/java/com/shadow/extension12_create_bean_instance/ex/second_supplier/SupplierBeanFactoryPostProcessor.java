package com.shadow.extension12_create_bean_instance.ex.second_supplier;

import com.shadow.extension12_create_bean_instance.test.SupplierInstantiation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class SupplierBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition bd = (GenericBeanDefinition) beanFactory.getBeanDefinition("supplierInstantiation");
        bd.setInstanceSupplier(CreateSupplier::createObject);
        bd.setBeanClass(SupplierInstantiation.class);
    }
}
