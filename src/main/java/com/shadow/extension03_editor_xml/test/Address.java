package com.shadow.extension03_editor_xml.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
@Data
@Accessors(chain = true)
public class Address {

    private String province;

    private String city;

    private String town;

}
