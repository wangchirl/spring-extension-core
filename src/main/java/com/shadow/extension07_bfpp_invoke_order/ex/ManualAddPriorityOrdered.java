package com.shadow.extension07_bfpp_invoke_order.ex;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class ManualAddPriorityOrdered implements BeanFactoryPostProcessor, PriorityOrdered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ConsolePrinter.printlnCyan("【manual add priorityOrdered】 BeanFactoryPostProcessor");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
