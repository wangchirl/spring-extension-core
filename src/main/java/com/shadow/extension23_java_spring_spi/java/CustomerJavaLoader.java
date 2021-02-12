package com.shadow.extension23_java_spring_spi.java;

import com.shadow.extension23_java_spring_spi.common.Loader;
import com.shadow.utils.ConsolePrinter;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class CustomerJavaLoader implements Loader {
    @Override
    public void load() {
        ConsolePrinter.printlnYellow("java SPI 加载...loading");
    }

    @Override
    public void link() {
        ConsolePrinter.printlnYellow("java SPI 链接...linking ==> [验证 Verification(是否满足字节码规范) -> 准备Preparation(静态变量赋默认值) -> 解析 Resolution(符号引用变直接引用) ]");
    }

    @Override
    public void initial() {
        ConsolePrinter.printlnYellow("java SPI 初始化...initialing(静态变量赋初始值)");
    }
}
