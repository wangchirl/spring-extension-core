package com.shadow.extension22_import_scan.ex.config;

import com.shadow.extension22_import_scan.ex.CustomerScanImportBeanDefinitionRegistrar;
import com.shadow.extension22_import_scan.ex.annotation.ShadowScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Configuration
@Import({CustomerScanImportBeanDefinitionRegistrar.class})
@ShadowScan(value = {"com.shadow.extension22_import_scan.test01","com.shadow.extension22_import_scan.test02"})
public class CustomerConfig {

}
