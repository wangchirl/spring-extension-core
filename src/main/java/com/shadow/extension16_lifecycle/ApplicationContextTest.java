package com.shadow.extension16_lifecycle;

import com.shadow.extension16_lifecycle.test.LiftCycleBean;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 * 1、bean 的生命周期：
 *  ① bean 的实例化
 *  ② bean 的属性填充
 *  ③ *Aware 接口方法设置属性
 *  ④ BPP 的 Before 回调方法
 *  ⑤ bean 的初始化方法
 *      @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
 *      自定义 init-method 初始化方法
 *  ⑥ BPP 的 After 回调方法
 *  ⑦ bean 的销毁
 *      @see org.springframework.beans.factory.DisposableBean#destroy
 *      自定义 destroy-method 销毁方法
 *
 *  2、初始化注解插曲
 *  @see javax.annotation.PostConstruct
 *  @see javax.annotation.PreDestroy
 *      处理类 ：
 *      @see org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-16.xml");
        LiftCycleBean bean = ac.getBean(LiftCycleBean.class);
        ConsolePrinter.printlnCyan(bean);
        ac.close();
    }

}
