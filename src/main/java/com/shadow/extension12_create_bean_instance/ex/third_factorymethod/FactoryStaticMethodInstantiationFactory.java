package com.shadow.extension12_create_bean_instance.ex.third_factorymethod;

import com.shadow.extension12_create_bean_instance.test.FactoryInstantiation;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 *  静态工厂方法
 */
public class FactoryStaticMethodInstantiationFactory {

    public static FactoryInstantiation getObject(String name) {
        FactoryInstantiation instantiation = new FactoryInstantiation();
        instantiation.setAge(20).setName(name);
        return instantiation;
    }

    public static FactoryInstantiation getObject(int age) {
        FactoryInstantiation instantiation = new FactoryInstantiation();
        instantiation.setAge(age).setName("李四");
        return instantiation;
    }
}
