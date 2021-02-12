package com.shadow.extension19_aop.xml.service;

import com.shadow.utils.ConsolePrinter;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public int add(int i, int j) {
        int res = i + j;
        ConsolePrinter.printlnYellow(i +" + " + j + " = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        ConsolePrinter.printlnYellow(i + " - " + j + " = " + res);
        return res;
    }

    @Override
    public int muti(int i, int j) {
        int res = i * j;
        ConsolePrinter.printlnYellow(i + " * " + j + " = " + res);
        return res;
    }

    @Override
    public int div(int i, int j) {
        int res = i / j;
        ConsolePrinter.printlnYellow(i + " / " + j + " = " + res);
        return res;
    }

    @Override
    public void show() {
        ConsolePrinter.printlnYellow("hello world ...");
    }
}
