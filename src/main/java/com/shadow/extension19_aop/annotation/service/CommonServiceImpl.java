package com.shadow.extension19_aop.annotation.service;

import com.shadow.extension19_aop.annotation.annotation.SysLog;
import com.shadow.utils.ConsolePrinter;
import org.springframework.stereotype.Service;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Service
public class CommonServiceImpl implements CommonService{

    @Override
    public void say(String word) {
        ConsolePrinter.printlnYellow("say hello world " + word);
    }

    @Override
    @SysLog
    public int add(int i, int j) {
        int res = i + j;
        ConsolePrinter.printlnYellow(i + " add " + j + " = " + res);
        return res;
    }

    @Override
    @SysLog
    public void run() {
        ConsolePrinter.printlnYellow("running....");
    }

    @Override
    public void dance() {
        ConsolePrinter.printlnYellow("dancing....");
    }
}
