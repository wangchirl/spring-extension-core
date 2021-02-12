package com.shadow.extension01_bean_name.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
@Service
public class TService {

    @Autowired
    private TDao tDao;

}

