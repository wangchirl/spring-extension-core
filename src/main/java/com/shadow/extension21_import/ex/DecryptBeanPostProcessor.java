package com.shadow.extension21_import.ex;

import com.shadow.extension21_import.test.Account;
import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class DecryptBeanPostProcessor implements BeanPostProcessor , PriorityOrdered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Account) {
            ConsolePrinter.printlnYellow("解密 ==> " + ((Account) bean).getName() + " ==> 马化腾");
            ((Account) bean).setName("马化腾");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
