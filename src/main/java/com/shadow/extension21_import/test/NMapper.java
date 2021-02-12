package com.shadow.extension21_import.test;

import com.shadow.utils.ConsolePrinter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class NMapper {

    private String name;

    public NMapper() {
        ConsolePrinter.printlnRed("NMapper ... 实例化");
    }
}
