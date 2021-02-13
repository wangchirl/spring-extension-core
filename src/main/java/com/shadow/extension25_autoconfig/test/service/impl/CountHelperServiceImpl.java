package com.shadow.extension25_autoconfig.test.service.impl;

import com.shadow.extension25_autoconfig.ex.annotation.DynamicDatasource;
import com.shadow.extension25_autoconfig.test.entity.CountHelper;
import com.shadow.extension25_autoconfig.test.mapper.CountHelperMapper;
import com.shadow.extension25_autoconfig.test.service.CountHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Service
@DynamicDatasource(value = "db02")
public class CountHelperServiceImpl implements CountHelperService {

    @Autowired
    private CountHelperMapper countHelperMapper;

    @Override
    @Transactional
    @DynamicDatasource(value = "db02")
    public void batchSave() {
        // 1. delete
        countHelperMapper.deleteAll();
        // 2. insert
        ArrayList<CountHelper> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CountHelper countHelper = new CountHelper();
            countHelper.setFnAccount("XXX" + i);
            countHelper.setType(i % 2);
            countHelper.setCount((int) (Math.random() * 10));
            countHelper.setDate(i + 10);
            countHelper.setMonth(i);
            countHelper.setYear(2021);
            list.add(countHelper);
        }
        countHelperMapper.batchSave(list);
    }

    @Override
    public List<CountHelper> queryAll() {
        return countHelperMapper.queryAll();
    }
}
