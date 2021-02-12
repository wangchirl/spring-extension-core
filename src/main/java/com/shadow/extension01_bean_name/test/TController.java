package com.shadow.extension01_bean_name.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
@Controller
public class TController {

    @Autowired
    private TService tService;
}
