package com.shadow.extension22_import_scan.test01;

import com.shadow.extension22_import_scan.ex.annotation.Shadow;
import com.shadow.extension22_import_scan.test02.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Shadow
public class HiService {

    @Autowired
    private HiMapper hiMapper;

    @Autowired
    private HelloMapper helloMapper;
}
