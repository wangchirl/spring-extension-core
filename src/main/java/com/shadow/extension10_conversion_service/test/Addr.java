package com.shadow.extension10_conversion_service.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Data
@Accessors(chain = true)
public class Addr {

    private String province;

    private String city;

    private String town;
}
