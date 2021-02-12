package com.shadow.extension15_cycle.test;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Data
@Accessors(chain = true)
public class A {

    private B b;
}
