package com.shadow.extension24_condition.ex;

import com.shadow.extension24_condition.test.E;
import com.shadow.extension24_condition.test.Q;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Configuration

public class CustomerConfig {

    @Bean
    @Conditional(CustomerCondition.class)
    @Order
    public E e() {
        return new E();
    }

    @Bean
    @ConditionalOnMissingBean(name = "e")
    public Q q() {
        return new Q();
    }

}
