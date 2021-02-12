package com.shadow.extension17_factory_bean.ex;

import com.shadow.extension17_factory_bean.test.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class MyFactoryBean<T> implements FactoryBean<T> {
    @Override
    public T getObject() throws Exception {
        return (T) new User("FactoryBean User");
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
