package com.shadow.extension12_create_bean_instance.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Data
@Accessors(chain = true)
public class FactoryInstantiation {
    private String name;
    private int age;
}
