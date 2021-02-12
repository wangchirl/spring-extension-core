package com.shadow.extension18_proxy_jdk_cglib.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class CglibProxyFactory {

    public static CglibCalculator proxy() {
        // 生产 class 本地文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, System.getProperty("user.dir"));
        Enhancer enhancer = new Enhancer();
        // 设置 要代理的 父类
        enhancer.setSuperclass(CglibCalculator.class);
        // 设置回调
        enhancer.setCallback(new CalculatorCallback());
        // 创建代理对象
        return (CglibCalculator) enhancer.create();
    }
}
