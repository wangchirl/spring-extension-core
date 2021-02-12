package com.shadow.extension23_java_spring_spi;

import com.shadow.extension23_java_spring_spi.common.Loader;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、JAVA SPI 机制：
 *      ① 接口
 *      ② 实现类
 *      ③ META-INF/services/接口全类名文件
 *      ④ 接口全类名文件中写入具体的实现类，多个实现可换行处理
 *   原理：
 *      @see ServiceLoader#load(Class)
 *
 *  2、Spring SPI 机制：
 *      ① 接口
 *      ② 接口实现类
 *      ③ META-INF/spring.factories 文件
 *      ④ spring.factories 文件中写入 接口全类名=接口实现类全类名，多个以英文逗号隔开
 *
 *    原理：
 *      @see SpringFactoriesLoader#loadFactories(Class, ClassLoader)
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、Java SPI
        ServiceLoader<Loader> loader = ServiceLoader.load(Loader.class);
        Iterator<Loader> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Loader next = iterator.next();
            next.load();
            next.link();
            next.initial();
        }

        ConsolePrinter.printlnRed("----------------");

        // 2、Spring SPI
        List<Loader> list = SpringFactoriesLoader.loadFactories(Loader.class , Thread.currentThread().getContextClassLoader());
        list.forEach(Loader::load);
        list.forEach(Loader::link);
        list.forEach(Loader::initial);

    }

}
