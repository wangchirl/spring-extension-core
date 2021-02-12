package com.shadow.utils;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public final class ConsolePrinter {

    public static void printlnCyan(Object... s1) {
        System.out.println(ConsoleColors.CYAN + Arrays.toString(s1) + ConsoleColors.RESET);
    }

    public static void printlnRed(Object... s1) {
        System.out.println(ConsoleColors.RED + Arrays.toString(s1) + ConsoleColors.RESET);
    }

    public static void printlnYellow(Object... s1) {
        System.out.println(ConsoleColors.YELLOW + Arrays.toString(s1) + ConsoleColors.RESET);
    }

    public static void printlnPurple(Object... s1) {
        System.out.println(ConsoleColors.PURPLE + Arrays.toString(s1) + ConsoleColors.RESET);
    }
}
