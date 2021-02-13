package com.shadow.extension25_autoconfig.ex.innerconfig;

import com.shadow.extension25_autoconfig.ex.common.DynamicDatasource;
import com.shadow.extension25_autoconfig.ex.factory.DynamicHikariDatasourceFactory;
import com.shadow.extension25_autoconfig.ex.properties.DatasourceProperties;
import com.shadow.extension25_autoconfig.ex.properties.DynamicDatasourceProperties;
import com.shadow.extension25_autoconfig.ex.support.DynamicDatasourceImportSelector;
import com.shadow.extension25_autoconfig.ex.support.DynamicDatsourceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Configuration
@Import(DynamicDatasourceImportSelector.class)
@ConditionalOnBean(EnableDynamicDatasourceMarker.Marker.class)
@EnableConfigurationProperties(DynamicDatasourceProperties.class)
public class DynamicDatasourceAutoConfig {

    @Autowired
    private DynamicDatasourceProperties dynamicDatasourceProperties;

    /**
     * 默认数据源
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DatasourceProperties datasourceProperties() {
        return new DatasourceProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public DynamicDatasource dynamicDatasource(DatasourceProperties datasourceProperties) {
        DynamicDatasource dynamicDatasource = new DynamicDatasource();
        // 设置目标数据源
        dynamicDatasource.setTargetDataSources(DynamicDatsourceSupport.getDynamicDatasource(dynamicDatasourceProperties.getDatasources()));
        // 设置默认数据源
        dynamicDatasource.setDefaultTargetDataSource(DynamicHikariDatasourceFactory.buildHikariDatasource(datasourceProperties));
        return dynamicDatasource;
    }

}
