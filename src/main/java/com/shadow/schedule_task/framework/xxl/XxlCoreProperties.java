package com.shadow.schedule_task.framework.xxl;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "xxl.job")
public class XxlCoreProperties {

    private XxlExecutorProperties executor = new XxlExecutorProperties();

    private String accessToken;

    private String adminAddresses;

}
