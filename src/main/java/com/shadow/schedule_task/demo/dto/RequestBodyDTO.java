package com.shadow.schedule_task.demo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class RequestBodyDTO {

    @NotNull
    private String option;

    @NotNull
    private String taskKey;

    @NotNull
    private String cronExpression;
}
