package com.shadow.extension12_create_bean_instance.ex.first_instantiation;


import com.shadow.utils.ConsolePrinter;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        ConsolePrinter.printlnYellow("目标方法执行之前：" + method.getName());
        Object res = methodProxy.invokeSuper(o, objects);
        ConsolePrinter.printlnRed("目标方法执行之后：" + method.getName());
        return res;
    }
}
