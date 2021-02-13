package com.shadow.extension25_autoconfig.ex.factory;

import com.alibaba.druid.pool.DruidDataSource;
import com.shadow.extension25_autoconfig.ex.properties.DatasourceProperties;

import java.sql.SQLException;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
public class DynamicDruidDatasourceFactory {

    public static DruidDataSource buildDruidDatasource(DatasourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setMinIdle(properties.getMinIdle());
        dataSource.setMaxWait(properties.getMaxWait());
        dataSource.setTimeBetweenConnectErrorMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        dataSource.setMaxEvictableIdleTimeMillis(properties.getMaxEvictableIdleTimeMillis());
        dataSource.setValidationQuery(properties.getValidationQuery());
        dataSource.setValidationQueryTimeout(properties.getValidationQueryTimeout());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        dataSource.setMaxOpenPreparedStatements(properties.getMaxOpenPreparedStatements());
        dataSource.setSharePreparedStatements(properties.isSharePreparedStatements());
        try {
            dataSource.setFilters(properties.getFilters());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dataSource;
    }

}
