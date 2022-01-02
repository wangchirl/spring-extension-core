package com.shadow.schedule_task.framework.xxl;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(XxlCoreProperties.class)
public class XxlJobConfig {

    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);

    @Bean
    public XxlJobSpringExecutor xxlJobSpringExecutor(XxlCoreProperties xxlCoreProperties) {
        logger.info(">>>> xxl-jb config init.");
        XxlJobSpringExecutor executor = new XxlJobSpringExecutor();
        executor.setAdminAddresses(xxlCoreProperties.getAdminAddresses());
        executor.setAppname(xxlCoreProperties.getExecutor().getAppname());
        executor.setIp(xxlCoreProperties.getExecutor().getIp());
        executor.setPort(xxlCoreProperties.getExecutor().getPort());
        executor.setAccessToken(xxlCoreProperties.getAccessToken());
        executor.setLogPath(xxlCoreProperties.getExecutor().getLogpath());
        executor.setLogRetentionDays(xxlCoreProperties.getExecutor().getLogretentiondays());
        return executor;
    }

}
