package com.shadow.extension04_editor_annotation.test;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
@Data
@Accessors(chain = true)
public class Human {

    @Value("${human.name}")
    private String name;

    @Value("${human.pet}")
    private Pet pet;

}
