package com.shadow.extension16_lifecycle.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class LiftCycleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        ConsolePrinter.printlnCyan("④、LiftCycleBean BPP Before");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ConsolePrinter.printlnCyan("⑥、LiftCycleBean BPP After");
        return bean;
    }
}
