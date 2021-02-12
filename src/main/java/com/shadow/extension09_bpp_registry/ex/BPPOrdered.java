package com.shadow.extension09_bpp_registry.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class BPPOrdered implements BeanPostProcessor, Ordered {

    public BPPOrdered() {
        ConsolePrinter.printlnRed("Ordered BeanPostProcessor init");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        ConsolePrinter.printlnCyan("Ordered BPP postProcessBeforeInitialization method invoke...");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ConsolePrinter.printlnCyan("Ordered BPP postProcessAfterInitialization method invoke...");
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
