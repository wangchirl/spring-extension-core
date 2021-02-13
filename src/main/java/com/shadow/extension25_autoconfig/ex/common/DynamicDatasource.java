package com.shadow.extension25_autoconfig.ex.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 *
 * 多数据源 - 交给 IOC 容器管理，执行 getConnect() 获取数据库连接时回调
 */
public class DynamicDatasource extends AbstractRoutingDataSource {

    /**
     * 拿到当前线程锁拥有的数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicContextHolder.peek();
    }
}
