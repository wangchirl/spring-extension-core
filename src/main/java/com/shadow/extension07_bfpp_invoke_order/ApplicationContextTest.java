package com.shadow.extension07_bfpp_invoke_order;

import com.shadow.extension07_bfpp_invoke_order.ex.ManualAddBFPPNoOrdered;
import com.shadow.extension07_bfpp_invoke_order.ex.ManualAddOrdered;
import com.shadow.extension07_bfpp_invoke_order.ex.ManualAddPriorityOrdered;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、这里手动 add 到工厂的 BFPP 是按照 add 的顺序执行的
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext();
        ac.addBeanFactoryPostProcessor(new ManualAddBFPPNoOrdered()); // 1
        ac.addBeanFactoryPostProcessor(new ManualAddOrdered()); // 2
        ac.addBeanFactoryPostProcessor(new ManualAddPriorityOrdered()); // 3
        ac.refresh();

        // 2、解析配置文件得到的 BFPP 是按照 PriorityOrdered -> Ordered -> NoOrdered 顺序执行的
        ClassPathXmlApplicationContext ac1 =
                new ClassPathXmlApplicationContext("classpath:config/extension-07.xml");

        // 3、源码首先会执行我们手动 add 到工厂的 BFPP，然后执行解析到的 BFPP ，按照 PriorityOrdered -> Ordered -> NoOrdered 顺序执行
        // BFPP 修改 bean 的定义信息 BD
    }

}
