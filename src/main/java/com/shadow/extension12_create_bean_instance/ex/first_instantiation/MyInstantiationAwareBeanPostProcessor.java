package com.shadow.extension12_create_bean_instance.ex.first_instantiation;

import com.shadow.extension12_create_bean_instance.test.BeforeInstantiation;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    private boolean proxy = true;

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass == BeforeInstantiation.class) {
            if(proxy) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(beanClass);
                enhancer.setCallback(new MyMethodInterceptor());
                BeforeInstantiation o = (BeforeInstantiation) enhancer.create();
                ConsolePrinter.printlnCyan("创建代理对象：" + o);
                return o;
            }else {
                return new BeforeInstantiation();
            }
        }
        return null;
    }
}
