package com.shadow.extension22_import_scan;

import com.shadow.extension22_import_scan.ex.config.CustomerConfig;
import com.shadow.extension22_import_scan.test01.HiController;
import com.shadow.extension22_import_scan.test01.HiService;
import com.shadow.utils.ConsolePrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 *
 *  1、自定义注解扫描：技术参考 Dubbo 的 ServiceBean 注解类注册
 *      ① @Shadow -> @Component
 *      ② @ShadowScan -> @ComponentScan
 *      ③ ShadowBeanFactoryPostProcessor -> org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationBeanPostProcessor
 *          @see org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationBeanPostProcessor
 *      ④ CustomerScanImportBeanDefinitionRegistrar -> org.apache.dubbo.config.spring.context.annotation.DubboComponentScanRegistrar
 *          @see org.apache.dubbo.config.spring.context.annotation.DubboComponentScanRegistrar
 *      ⑤ 自定义扫描器  ShadowBeanScannner
 *
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CustomerConfig.class);
        HiController bean = ac.getBean(HiController.class);
        ConsolePrinter.printlnYellow(bean);
        HiService hiService = ac.getBean(HiService.class);
        ConsolePrinter.printlnYellow(bean.hiService == hiService);

    }

}
