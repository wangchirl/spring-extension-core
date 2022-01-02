package com.shadow.schedule_task.demo.vo;

import com.shadow.schedule_task.framework.support.ScheduleResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ScheduleInfoVO<T> {

    private String taskName;

    private String taskKey;

    private String taskCron;

    private transient ScheduleResult<T> result;

}
