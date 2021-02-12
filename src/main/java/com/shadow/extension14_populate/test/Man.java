package com.shadow.extension14_populate.test;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Data
@Accessors(chain = true)
public class Man {

    private int id;
    private String name;
    private int age;
    private String gender;
    private Address address;
    private String[] hobbies;
    private List<Book> books;
    private Set<Integer> coins;
    private Map<String,Object> packages;
    private Properties properties;

}
