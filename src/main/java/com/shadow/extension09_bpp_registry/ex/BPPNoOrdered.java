package com.shadow.extension09_bpp_registry.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class BPPNoOrdered implements BeanPostProcessor {

    public BPPNoOrdered() {
        ConsolePrinter.printlnRed("noOrdered BeanPostProcessor init");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        ConsolePrinter.printlnCyan("noOrdered BPP postProcessBeforeInitialization method invoke...");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ConsolePrinter.printlnCyan("noOrdered BPP postProcessAfterInitialization method invoke...");
        return bean;
    }

}
