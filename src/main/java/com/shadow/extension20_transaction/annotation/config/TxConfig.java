package com.shadow.extension20_transaction.annotation.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Configuration
@ComponentScan("com.shadow.extension20_transaction.annotation")
@PropertySource("classpath:extension20.properties")
@EnableTransactionManagement
public class TxConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    // 配置数据源
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setJdbcUrl(url);
        return dataSource;
    }
    // 配置JdbcTemplate

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    // 配置事务管理器
    @Bean
    public PlatformTransactionManager dataSourceManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
