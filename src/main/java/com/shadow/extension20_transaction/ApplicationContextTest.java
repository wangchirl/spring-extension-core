package com.shadow.extension20_transaction;

import com.shadow.extension20_transaction.annotation.AnnotationBookService;
import com.shadow.extension20_transaction.annotation.config.TxConfig;
import com.shadow.extension20_transaction.xml.XmlBookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、事务隔离级别
 *  @see org.springframework.transaction.annotation.Isolation
 *      ① DEFAULT - 与数据库事务隔离级别保存一致
 *      ② READ_UNCOMMITTED - 读未提交
 *      ③ READ_COMMITTED - 读已提交
 *      ④ REPEATABLE_READ - 可重复读
 *      ⑤ SERIALIZABLE - 可串行化
 *
 *  2、事务传播机制
 *  @see org.springframework.transaction.annotation.Propagation
 *    一、支持当前事务的
 *      ① REQUIRED - 使用当前事务，没有就创建
 *      ② SUPPORTS - 当前有事务就使用当前事务，当前没有事务就不用事务
 *      ③ MANDATORY - 使用当前事务，没有就报错
 *    二、不支持当前事务的
 *      ① REQUIRES_NEW - 当前存在事务就挂起当前事务，重新创建一个新事务
 *      ② NOT_SUPPORTED - 不需要事务，当前存在事务就挂起事务
 *      ③ NEVER - 不需要事务，存在事务就报错
 *    三、内嵌事务
 *      ① NESTED - 当前存在事务，创建保存点，新建一个事务
 *
 *  3、声明式事务注解
 *  @see org.springframework.transaction.annotation.Transactional
 *
 *  4、事务管理器
 *  @see org.springframework.transaction.PlatformTransactionManager
 *  @see org.springframework.jdbc.datasource.DataSourceTransactionManager
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        // 1、XML 事务方式
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:config/extension-20.xml");
        XmlBookService bean = ac.getBean(XmlBookService.class);
        bean.checkout("X",1);

        // 2、注解方式
        AnnotationConfigApplicationContext ac1 = new AnnotationConfigApplicationContext(TxConfig.class);
        AnnotationBookService service = ac1.getBean(AnnotationBookService.class);
        service.checkout("X",1);
    }

}
