package com.shadow.extension13_method_override.ex.replace;

import com.shadow.utils.ConsolePrinter;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class MyMethodReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        ConsolePrinter.printlnRed("hello i am upstream...");
        Arrays.stream(objects).forEach(s -> ConsolePrinter.printlnCyan("参数 = " + s));
        return o;
    }
}
