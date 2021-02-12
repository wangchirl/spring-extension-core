package com.shadow.extension10_conversion_service.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public enum HumanEnum {
    MAN("0", "男人"),
    WOMEN("1", "女人")
    ;
    private String code;
    private String name;

    HumanEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
