package com.shadow.extension22_import_scan.test01;

import com.shadow.extension22_import_scan.ex.annotation.Shadow;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Shadow
public class HiController {

    @Autowired
    public HiService hiService;

}
