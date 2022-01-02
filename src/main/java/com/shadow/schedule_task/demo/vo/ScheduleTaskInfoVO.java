package com.shadow.schedule_task.demo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ScheduleTaskInfoVO {

    private String taskName;

    private String taskKey;

}
