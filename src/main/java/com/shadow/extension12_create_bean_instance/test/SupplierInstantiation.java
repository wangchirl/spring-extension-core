package com.shadow.extension12_create_bean_instance.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SupplierInstantiation {

    private String name;

}
