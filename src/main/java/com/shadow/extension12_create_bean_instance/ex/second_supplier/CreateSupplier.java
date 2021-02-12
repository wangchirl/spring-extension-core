package com.shadow.extension12_create_bean_instance.ex.second_supplier;

import com.shadow.extension12_create_bean_instance.test.SupplierInstantiation;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class CreateSupplier {

    public static Object createObject() {
        return new SupplierInstantiation("supplier obj");
    }
}
