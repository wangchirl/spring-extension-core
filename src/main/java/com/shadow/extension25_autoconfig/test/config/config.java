package com.shadow.extension25_autoconfig.test.config;

import com.shadow.extension25_autoconfig.ex.annotation.EnableAutoDynamicDatasource;
import com.shadow.extension25_autoconfig.ex.mybatis.interceptor.CustomerExecuteInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Configuration
@EnableAutoDynamicDatasource
public class config {

//    @Bean
//    public CustomerExecuteInterceptor customerExecuteInterceptor() {
//        return new CustomerExecuteInterceptor();
//    }
}
