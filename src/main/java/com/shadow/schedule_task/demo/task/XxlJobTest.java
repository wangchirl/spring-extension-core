package com.shadow.schedule_task.demo.task;

import com.shadow.schedule_task.demo.constants.ScheduleTaskNameConstants;
import com.shadow.schedule_task.framework.support.JobHandlerSupport;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class XxlJobTest extends JobHandlerSupport {

    @XxlJob(value = ScheduleTaskNameConstants.TEST)
    public void test() {
        String param = XxlJobHelper.getJobParam();
        getScheduleService().test(param);
    }

}
