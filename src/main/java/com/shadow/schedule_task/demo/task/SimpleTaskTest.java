package com.shadow.schedule_task.demo.task;

import com.shadow.schedule_task.demo.constants.ScheduleTaskInfoEnum;
import com.shadow.schedule_task.demo.constants.ScheduleTaskNameConstants;
import com.shadow.schedule_task.framework.ICronTriggerTask;
import com.shadow.schedule_task.framework.support.JobHandlerSupport;
import com.shadow.schedule_task.framework.support.TriggerTaskHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 推荐方式
 */
@Configuration
public class SimpleTaskTest extends JobHandlerSupport {

    @Bean(value = ScheduleTaskNameConstants.TEST)
    public ICronTriggerTask<Integer> test() {
        return new TriggerTaskHelper<Integer>().generateTask(ScheduleTaskInfoEnum.TEST_NORMAL_TASK,(p) -> {
           return getScheduleService().test(p);
        });
    }

    @Bean(value = ScheduleTaskNameConstants.TEST_DISTRIBUTION)
    public ICronTriggerTask<Integer> testDis() {
        return new TriggerTaskHelper<Integer>().generateTask(ScheduleTaskInfoEnum.TEST_DISTRIBUTION_TASK,(p) -> {
            return getScheduleService().testDis(p);
        });
    }

}
