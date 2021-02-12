package com.shadow.extension12_create_bean_instance.config;

import com.shadow.extension12_create_bean_instance.ex.first_instantiation.MyInstantiationAwareBeanPostProcessor;
import com.shadow.extension12_create_bean_instance.test.BeforeInstantiation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Configuration
public class InstantiationConfig {

    @Bean
    public MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor() {
        return new MyInstantiationAwareBeanPostProcessor();
    }

    @Bean
    public BeforeInstantiation beforeInstantiation() {
        return new BeforeInstantiation();
    }
}
