package com.shadow.extension13_method_override.ex.lookup;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Data
@Accessors(chain = true)
public class Person {

    private Car car;

}
