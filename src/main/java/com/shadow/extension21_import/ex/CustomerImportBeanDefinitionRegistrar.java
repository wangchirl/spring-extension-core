package com.shadow.extension21_import.ex;

import com.shadow.extension21_import.test.MMapper;
import com.shadow.extension21_import.test.NMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class CustomerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AbstractBeanDefinition beanDefinition =
                BeanDefinitionBuilder.genericBeanDefinition(NMapper.class).addPropertyValue("name", "赫本").getBeanDefinition();
        AbstractBeanDefinition definition = BeanDefinitionBuilder.rootBeanDefinition(MMapper.class).getBeanDefinition();
        definition.setLazyInit(true); // MMapper 懒加载
        registry.registerBeanDefinition("nMapper",beanDefinition);
        registry.registerBeanDefinition("mMapper",definition);
    }
}
