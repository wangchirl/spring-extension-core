package com.shadow.schedule_task.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class RequestBodyDTO {

    @NotNull
    private String option;

    @NotNull
    private String type;

    @NotNull
    private String cron;
}
