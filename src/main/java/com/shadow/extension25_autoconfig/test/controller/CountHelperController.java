package com.shadow.extension25_autoconfig.test.controller;

import com.shadow.extension25_autoconfig.test.entity.Account;
import com.shadow.extension25_autoconfig.test.entity.CountHelper;
import com.shadow.extension25_autoconfig.test.service.AccountService;
import com.shadow.extension25_autoconfig.test.service.CountHelperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@RestController
@Slf4j
public class CountHelperController {

    @Autowired
    private CountHelperService countHelperService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/query")
    public List<Object> count() {
        // db01
        List<Account> accounts = accountService.queryAll();
        // db02
        countHelperService.batchSave();
        // db02
        List<CountHelper> countHelpers = countHelperService.queryAll();
        ArrayList<Object> list = new ArrayList<>();
        list.addAll(accounts);
        list.addAll(countHelpers);
        return list;
    }

}
