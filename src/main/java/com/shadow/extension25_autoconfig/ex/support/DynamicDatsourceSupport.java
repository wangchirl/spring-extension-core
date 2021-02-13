package com.shadow.extension25_autoconfig.ex.support;

import com.shadow.extension25_autoconfig.ex.factory.DynamicHikariDatasourceFactory;
import com.shadow.extension25_autoconfig.ex.properties.DatasourceProperties;
import com.zaxxer.hikari.HikariDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
public class DynamicDatsourceSupport {

    /**
     * 获取动态数据源
     * @param datasourcePropertiesMap
     * @return
     */
    public static Map<Object, Object> getDynamicDatasource(Map<String, DatasourceProperties> datasourcePropertiesMap) {
        Map<Object, Object> targetDatasources = new HashMap<>(datasourcePropertiesMap.size());
        datasourcePropertiesMap.forEach((k,v) -> {
            HikariDataSource hikariDataSource = DynamicHikariDatasourceFactory.buildHikariDatasource(v);
            targetDatasources.put(k, hikariDataSource);
        });
        return targetDatasources;
    }
}
