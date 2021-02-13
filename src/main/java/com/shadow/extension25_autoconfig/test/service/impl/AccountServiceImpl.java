package com.shadow.extension25_autoconfig.test.service.impl;

import com.shadow.extension25_autoconfig.ex.annotation.DynamicDatasource;
import com.shadow.extension25_autoconfig.test.entity.Account;
import com.shadow.extension25_autoconfig.test.mapper.AccountMapper;
import com.shadow.extension25_autoconfig.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Service
@DynamicDatasource(value = "db01")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> queryAll() {
        return accountMapper.queryAll();
    }
}
