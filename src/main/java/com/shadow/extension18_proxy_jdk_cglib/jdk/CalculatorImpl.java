package com.shadow.extension18_proxy_jdk_cglib.jdk;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int muti(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
