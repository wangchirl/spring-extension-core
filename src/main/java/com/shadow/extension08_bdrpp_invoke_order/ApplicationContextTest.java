package com.shadow.extension08_bdrpp_invoke_order;

import com.shadow.extension08_bdrpp_invoke_order.ex.ManualAddBDRPPNoOrdered;
import com.shadow.extension08_bdrpp_invoke_order.ex.ManualAddBDRPPOrdered;
import com.shadow.extension08_bdrpp_invoke_order.ex.ManualAddBDRPPPriorityOrdered;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 * 1、BDRPP 有执行顺序
 *  ① 首先执行用户通过编程方式手动注册的 BDRPP 的方法
 *  ② 再执行实现了 PriorityOrdered 接口的排序后的 BDRPP 的方法
 *  ③ 然后执行实现了 Ordered 接口的排序后的 BDRPP 的方法
 *  ④ 最后执行没有实现上面2个接口的 BDRPP 的方法
 *  ⑤ 执行 BFPP 的方法
 *  >>> 按序执行的理由：BDRPP 可以注册 BDRPP 到工厂中
 * @see org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry)
 *
 * 2、BFPP 有执行顺序
 *  ① 首先执行实现了 PriorityOrdered 接口的排序后的 BFPP 的方法
 *  ② 再执行实现了 Ordered 接口的排序后的 BFPP 的方法
 *  ③ 最后执行没有实现上面2个接口的 BFPP 的方法
 *  >>> 处理 BeanDefinition 的顺序
 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、手动 add 到工厂的BDRPP 是 BFPP 的子接口，是按照添加的顺序执行的
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext();
        ac.addBeanFactoryPostProcessor(new ManualAddBDRPPNoOrdered());
        ac.addBeanFactoryPostProcessor(new ManualAddBDRPPOrdered());
        ac.addBeanFactoryPostProcessor(new ManualAddBDRPPPriorityOrdered());
        ac.refresh();

        // 2、解析得到的 BDRPP 是按照 PriorityOrdered -> Ordered -> NoOrdered 顺序执行的
        ClassPathXmlApplicationContext ac1 =
                new ClassPathXmlApplicationContext("classpath:config/extension-08.xml");
    }

}
