package com.shadow.extension13_method_override.ex.lookup;

import jdk.nashorn.internal.runtime.PrototypeObject;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Component
public abstract class SingletonObj {

    public void dosomething() {
        ProtoTypeObj obj = protoTypeObj();
        obj.m();
    }

    @Lookup
    public abstract ProtoTypeObj protoTypeObj();

}
