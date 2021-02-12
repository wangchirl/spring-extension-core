package com.shadow.extension12_create_bean_instance.config;

import com.shadow.extension12_create_bean_instance.ex.second_supplier.SupplierBeanFactoryPostProcessor;
import com.shadow.extension12_create_bean_instance.test.SupplierInstantiation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Configuration
public class SupplierConfig {

    @Bean
    public SupplierBeanFactoryPostProcessor supplierBeanFactoryPostProcessor() {
        return new SupplierBeanFactoryPostProcessor();
    }

}
