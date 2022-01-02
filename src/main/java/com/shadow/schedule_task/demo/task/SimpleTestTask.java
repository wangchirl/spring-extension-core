package com.shadow.schedule_task.demo.task;

import com.shadow.schedule_task.demo.constants.ScheduleTaskInfoEnum;
import com.shadow.schedule_task.demo.constants.ScheduleTaskNameConstants;
import com.shadow.schedule_task.framework.ScheduleService;
import com.shadow.schedule_task.framework.aop.SimpleJob;
import com.shadow.schedule_task.framework.support.CronTriggerSupport;
import org.springframework.stereotype.Component;

/**
 * 不推荐方式
 */
//@Component
public class SimpleTestTask extends CronTriggerSupport<Integer> {

    @Override
    public String type() {
        return ScheduleTaskNameConstants.TEST;
    }

    @Override
    public String getCronName() {
        return ScheduleTaskInfoEnum.TEST_NORMAL_TASK.getCronName();
    }

    @Override
    @SimpleJob(value = ScheduleTaskNameConstants.TEST)
    public Integer call() throws Exception {
        String params = ScheduleService.JOB_PARAMETERS_THREAD_LOCAL.get();
        return getScheduleService().test(params);
    }
}
