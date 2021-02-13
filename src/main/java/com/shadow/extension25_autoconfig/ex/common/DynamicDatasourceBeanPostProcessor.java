package com.shadow.extension25_autoconfig.ex.common;

import com.shadow.extension25_autoconfig.ex.properties.DatasourceProperties;
import com.shadow.extension25_autoconfig.ex.properties.DynamicDatasourceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

import java.util.Map;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 *
 *  BPP
 */
@Slf4j
public class DynamicDatasourceBeanPostProcessor implements BeanPostProcessor , PriorityOrdered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof DatasourceProperties) {
            try {
                DatasourceProperties properties = (DatasourceProperties) bean;
                // decode
            } catch (Exception e) {
                log.error("data source password decrypt error {}", e.getMessage());
            }
        }
        if(bean instanceof DynamicDatasourceProperties) {
            Map<String, DatasourceProperties> datasources = ((DynamicDatasourceProperties) bean).getDatasources();
            datasources.forEach((k,v) -> {
                try {
                    // decode
                } catch (Exception e) {
                    log.error("data source password decrypt error {}", e.getMessage());
                }
            });
        }
        return bean;
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
