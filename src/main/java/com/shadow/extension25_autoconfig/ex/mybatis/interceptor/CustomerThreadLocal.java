package com.shadow.extension25_autoconfig.ex.mybatis.interceptor;

import com.shadow.extension25_autoconfig.ex.common.BaseUser;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
public class CustomerThreadLocal {

    private CustomerThreadLocal() {}

    private static final ThreadLocal<BaseUser> USER_INFO_THREADLOCAL = new ThreadLocal<>();

    public static void set(BaseUser baseUser) {
        USER_INFO_THREADLOCAL.set(baseUser);
    }

    public static BaseUser get() {
        return USER_INFO_THREADLOCAL.get();
    }

    public static void remove() {
        USER_INFO_THREADLOCAL.remove();
    }

}

