package com.shadow.extension25_autoconfig.test.service;

import com.shadow.extension25_autoconfig.test.entity.CountHelper;

import java.util.List;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public interface CountHelperService {

    void batchSave();

    List<CountHelper> queryAll();

}
