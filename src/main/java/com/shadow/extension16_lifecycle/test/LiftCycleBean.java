package com.shadow.extension16_lifecycle.test;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class LiftCycleBean implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private BeanFactory beanFactory;
    private String beanName;

    public LiftCycleBean() {
        ConsolePrinter.printlnRed("①、LiftCycleBean 实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ConsolePrinter.printlnYellow("②、LiftCycleBean 属性填充");
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        ConsolePrinter.printlnRed("③、LiftCycleBean *Aware 接口设置依赖");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        ConsolePrinter.printlnRed("③、LiftCycleBean *Aware 接口设置依赖");
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ConsolePrinter.printlnPurple("⑤-①、LiftCycleBean InitialingBean#afterPropertiesSet 初始化");
    }

    public void initMethod0() {
        ConsolePrinter.printlnPurple("⑤-②、LiftCycleBean 自定义 init-method 初始化");
    }


    @Override
    public void destroy() throws Exception {
        ConsolePrinter.printlnRed("⑧-①、LiftCycleBean DisposableBean#destroy 销毁");
    }

    public void destroy0() {
        ConsolePrinter.printlnRed("⑧-②、LiftCycleBean 自定义 destroy-method 销毁");
    }

    @Override
    public String toString() {
        return "⑦、LiftCycleBean 使用中 ===> LiftCycleBean{" +
                "name='" + name + '\'' +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }
}
