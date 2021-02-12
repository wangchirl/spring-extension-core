package com.shadow.extension09_bpp_registry.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class BPPPriorityOrdered implements BeanPostProcessor, PriorityOrdered {

    public BPPPriorityOrdered() {
        ConsolePrinter.printlnRed("PriorityOrdered BeanPostProcessor init");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        ConsolePrinter.printlnCyan("PriorityOrdered BPP postProcessBeforeInitialization method invoke...");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ConsolePrinter.printlnCyan("PriorityOrdered BPP postProcessAfterInitialization method invoke...");
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
