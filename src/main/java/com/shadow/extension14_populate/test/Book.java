package com.shadow.extension14_populate.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Data
@Accessors(chain = true)
public class Book {

    private String name;
    private String author;
    private int price;

}
