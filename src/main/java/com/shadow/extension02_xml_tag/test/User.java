package com.shadow.extension02_xml_tag.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;

    private String email;

    private String password;

}
