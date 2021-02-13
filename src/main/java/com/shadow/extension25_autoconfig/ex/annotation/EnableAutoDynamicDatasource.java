package com.shadow.extension25_autoconfig.ex.annotation;

import com.shadow.extension25_autoconfig.ex.innerconfig.EnableDynamicDatasourceMarker;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(EnableDynamicDatasourceMarker.class)
public @interface EnableAutoDynamicDatasource {

}
