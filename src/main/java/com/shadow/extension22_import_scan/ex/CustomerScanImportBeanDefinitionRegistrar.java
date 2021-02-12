package com.shadow.extension22_import_scan.ex;

import com.shadow.extension22_import_scan.ex.annotation.ShadowScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class CustomerScanImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes attributes =
                AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ShadowScan.class.getName()));
        if(attributes != null) {
            registryBeanDefinitions(importingClassMetadata, attributes, registry);
        }
    }

    private void registryBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                         AnnotationAttributes attributes, BeanDefinitionRegistry registry) {
        // find packages
        Set<String> basePackages = getScanPackages(importingClassMetadata, attributes);
        // registry BFPP to handle scan
        registryShadowAnnotationBeanFactoryPostProcessor(basePackages, registry);
    }

    private Set<String> getScanPackages(AnnotationMetadata importingClassMetadata, AnnotationAttributes attributes) {
        // 扫描包
        Set<String> basePackages = new HashSet<>();
        // value
        basePackages.addAll(
                Arrays.stream(attributes.getStringArray("value")).filter(StringUtils::hasText).collect(Collectors.toList()));
        // basepackages
        basePackages.addAll(
                Arrays.stream(attributes.getStringArray("basePackages")).filter(StringUtils::hasText).collect(Collectors.toList()));
        // basePackageClasses
        basePackages.addAll(
                Arrays.stream(attributes.getClassArray("basePackageClasses")).map(ClassUtils::getPackageName).collect(Collectors.toList()));
        // local packages
        if(basePackages.isEmpty()) {
            basePackages.add(getDefaultBasePackage(importingClassMetadata));
        }
        return basePackages;
    }

    private String getDefaultBasePackage(AnnotationMetadata importingClassMetadata) {
        return ClassUtils.getPackageName(importingClassMetadata.getClassName());
    }

    private void registryShadowAnnotationBeanFactoryPostProcessor(Set<String> basePackages, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ShadowBeanFactoryPostProcessor.class);
        builder.addConstructorArgValue(basePackages);
        builder.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
    }
}
