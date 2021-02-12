package com.shadow.extension13_method_override.ex.replace;

import com.shadow.utils.ConsolePrinter;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class OriginObj {

    public void say() {
        ConsolePrinter.printlnYellow("hello world...");
    }

    public void say(String name) {
        ConsolePrinter.printlnRed("hello " + name);
    }

    public void say(String name, int age) {
        ConsolePrinter.printlnPurple("hello " + name + " age " + age);
    }

}
