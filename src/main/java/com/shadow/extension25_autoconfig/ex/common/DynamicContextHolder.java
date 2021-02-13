package com.shadow.extension25_autoconfig.ex.common;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 *
 * 多数据源 - 线程共享变量持有类 ThreadLocal -线程资源共享
 * 1、设置共享变量值
 * 2、获取共享变量值
 * 3、清空共享变量值
 */
public class DynamicContextHolder {

    /**
     * 线程共享变量持有者
     */
    private static final ThreadLocal<Deque<String>> CONTEXT_HOLDER = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new ArrayDeque<>();
        }
    };

    /**
     * 获取当前线程数据源
     * @return
     */
    public static String peek() {
        return CONTEXT_HOLDER.get().peek();
    }

    /**
     * 设置当前线程数据源
     * @param datasource
     */
    public static void push(String datasource) {
        CONTEXT_HOLDER.get().push(datasource);
    }


    /**
     * 清空当前线程数据源
     */
    public static void poll() {
        Deque<String> sources = CONTEXT_HOLDER.get();
        sources.poll();
        if(sources.isEmpty()) {
            CONTEXT_HOLDER.remove();
        }
    }
}
