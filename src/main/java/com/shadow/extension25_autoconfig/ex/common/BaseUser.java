package com.shadow.extension25_autoconfig.ex.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Data
@Accessors(chain = true)
public class BaseUser implements Serializable {

    private String id;

    private String username;

    private String password;

    private String nickname;

    private String mobile;

    private String email;

}
