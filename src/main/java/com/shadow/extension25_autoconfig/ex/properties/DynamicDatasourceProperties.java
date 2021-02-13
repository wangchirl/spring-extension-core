package com.shadow.extension25_autoconfig.ex.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(value = "dynamic")
@ConditionalOnMissingBean
public class DynamicDatasourceProperties {

    private Map<String,DatasourceProperties> datasources = new LinkedHashMap<>();

}
