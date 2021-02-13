package com.shadow.extension25_autoconfig.ex.innerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Configuration
public class EnableDynamicDatasourceMarker {


    @Bean
    public Marker marker() {
        return new Marker();
    }

    class Marker {

    }

}
