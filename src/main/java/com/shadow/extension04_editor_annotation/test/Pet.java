package com.shadow.extension04_editor_annotation.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
@Data
@Accessors(chain = true)
public class Pet {

    private String name;

    private int age;

    private String color;
}
