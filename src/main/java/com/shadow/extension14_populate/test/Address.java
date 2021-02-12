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
public class Address {

    private String province;
    private String city;
    private String town;

}
