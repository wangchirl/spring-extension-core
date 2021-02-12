package com.shadow.extension19_aop.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Configuration
@ComponentScan("com.shadow.extension19_aop.annotation")
@EnableAspectJAutoProxy
public class AopConfig {
}
