package com.shadow.extension25_autoconfig.ex.factory;

import com.shadow.extension25_autoconfig.ex.properties.DatasourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
public class DynamicHikariDatasourceFactory {

    public static HikariDataSource buildHikariDatasource(DatasourceProperties properties) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(properties.getDriverClassName());
        config.setJdbcUrl(properties.getUrl());
        config.setUsername(properties.getUsername());
        config.setPassword(properties.getPassword());
        config.setConnectionTimeout(properties.getConnectionTimeout());
        config.setValidationTimeout(properties.getValidationTimeout());
        config.setIdleTimeout(properties.getIdleTimeout());
        config.setMaxLifetime(properties.getMaxLifetime());
        config.setMaximumPoolSize(properties.getMaximumPoolSize());
        config.setMinimumIdle(properties.getMinimumIdle());
        config.setConnectionTestQuery(properties.getConnectionTestQuery());
        return new HikariDataSource(config);
    }
}
