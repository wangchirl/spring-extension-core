package com.shadow.schedule_task.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

@Data
@Accessors(chain = true)
public class ScheduleVO {

    private Set<String> activeTaskKeys;

    private List<ScheduleInfoVO> tasks;

}
