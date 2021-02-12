package com.shadow.extension12_create_bean_instance.ex.third_factorymethod;

import com.shadow.extension12_create_bean_instance.test.FactoryInstantiation;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 *  实例工厂方法
 */
public class FactoryMethodInstantiationFactory {
    public FactoryInstantiation getObject(String name) {
        FactoryInstantiation instantiation = new FactoryInstantiation();
        instantiation.setName(name).setAge(18);
        return instantiation;
    }
}
