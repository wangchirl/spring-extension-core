package com.shadow.extension21_import.ex.config;

import com.shadow.extension21_import.ex.CustomerImportSelector;
import com.shadow.extension21_import.ex.CustomerImportBeanDefinitionRegistrar;
import com.shadow.extension21_import.test.Account;
import com.shadow.extension21_import.test.NormalEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Configuration
@Import({CustomerImportBeanDefinitionRegistrar.class, CustomerImportSelector.class, NormalEntity.class})
@PropertySource("classpath:application.yml")
public class Config {

    @Bean
    public Account account() {
        Account account = new Account();
        account.setName("李四").setAge(20);
        return account;
    }
}
