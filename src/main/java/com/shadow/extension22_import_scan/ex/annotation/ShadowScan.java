package com.shadow.extension22_import_scan.ex.annotation;

import com.shadow.extension22_import_scan.ex.CustomerScanImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CustomerScanImportBeanDefinitionRegistrar.class)
public @interface ShadowScan {

    /**
     * 扫描包
     * @return
     */
    String[] value() default {};

    /**
     * 扫描包
     * @return
     */
    String[] basePackages() default {};

    /**
     * 扫描基类
     * @return
     */
    Class<?>[] basePackageClasses() default {};
}
