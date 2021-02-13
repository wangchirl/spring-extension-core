package com.shadow.extension25_autoconfig.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Data
@Accessors(chain = true)
public class Account implements Serializable {

    private long id;

    private String userName;

    private int balance;
}
