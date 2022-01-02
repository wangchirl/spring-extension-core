package com.shadow.schedule_task.framework.xxl;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class XxlExecutorProperties {

    private String appname;
    private String address;
    private String ip;
    private int port;
    private String logpath;
    private int logretentiondays;

}
