package com.shadow.extension07_bfpp_invoke_order.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class ManualAddBFPPNoOrdered implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ConsolePrinter.printlnCyan("【manual add noOrdered】 BeanFactoryPostProcessor");
    }
}
