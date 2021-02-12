package com.shadow.extension21_import.test;

import com.shadow.utils.ConsolePrinter;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Data
@Accessors(chain = true)
public class Account {

    private String name;
    private int age;

    public Account() {
        ConsolePrinter.printlnRed("Account ... 实例化");
    }

}
