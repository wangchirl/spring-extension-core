package com.shadow.extension06_bdrpp.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
@Data
@Accessors(chain = true)
public class Dog {

    private String name;

    private int age;
}
