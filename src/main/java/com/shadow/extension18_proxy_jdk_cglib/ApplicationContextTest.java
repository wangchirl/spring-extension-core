package com.shadow.extension18_proxy_jdk_cglib;

import com.shadow.extension18_proxy_jdk_cglib.cglib.CglibCalculator;
import com.shadow.extension18_proxy_jdk_cglib.cglib.CglibProxyFactory;
import com.shadow.extension18_proxy_jdk_cglib.jdk.Calculator;
import com.shadow.extension18_proxy_jdk_cglib.jdk.CalculatorImpl;
import com.shadow.extension18_proxy_jdk_cglib.jdk.JdkProxyFactory;
import com.shadow.utils.ConsolePrinter;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、JDK 动态代理（反射）
 *      -> 代理的类一定要是实现接口的类
 * @see java.lang.reflect.Proxy
 * @see java.lang.reflect.Proxy.ProxyClassFactory#apply(ClassLoader, Class[])
 * @see java.lang.reflect.InvocationHandler#invoke(Object, Method, Object[])
 *
 *  2、CGLIB 动态代理（ASM 字节码操作技术）
 *      -> 代理的类无需实现任何接口
 * @see org.springframework.cglib.proxy.Enhancer#setSuperclass(Class)
 * @see org.springframework.cglib.proxy.Enhancer#setCallback(Callback)
 * @see org.springframework.cglib.proxy.Enhancer#create()
 * @see org.springframework.cglib.proxy.MethodInterceptor#intercept(Object, Method, Object[], MethodProxy)
 *
 *  3、生产的动态代理类保存到本地
 *      -> JDK 动态代理
 *          System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true")
 *      -> CGLIB 动态代理
 *          System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, System.getProperty("user.dir"))
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、JDK 动态代理
        // 生产代理 class 文件到本地
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Calculator calculator = new CalculatorImpl();
        Calculator proxy = JdkProxyFactory.proxy(calculator);
        ConsolePrinter.printlnRed(proxy.add(1,1));
        ConsolePrinter.printlnCyan(proxy.getClass()); // com.sun.proxy.$Proxy0

        // 2、CGLIB 动态代理
        CglibCalculator proxy1 = CglibProxyFactory.proxy();
        ConsolePrinter.printlnCyan(proxy1.add(1,1));
        ConsolePrinter.printlnCyan(proxy1.getClass());
    }

}
