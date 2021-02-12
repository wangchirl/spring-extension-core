package com.shadow.extension18_proxy_jdk_cglib.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class JdkProxyFactory {

    public static Calculator proxy(final Calculator calculator) {
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(calculator, args);
            }
        };
        return (Calculator) Proxy.newProxyInstance(classLoader, interfaces, h);


    }

}
