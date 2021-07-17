package com.shadow.schedule_task.task;

import com.shadow.schedule_task.constants.ScheduleTaskInfoEnum;
import com.shadow.schedule_task.constants.ScheduleTaskNameConstants;
import com.shadow.schedule_task.support.CronTriggerSupport;
import com.shadow.utils.ConsolePrinter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class TestNormalTriggerTask extends CronTriggerSupport implements Runnable {

    @Override
    protected String cronExpressionName() {
        return ScheduleTaskInfoEnum.TEST_NORMAL_TASK.getCronName();
    }

    @Override
    public String type() {
        return ScheduleTaskNameConstants.TEST;
    }

    @Override
    public void run() {
        log.info("schedule task type {} start ", type());
        CompletableFuture.supplyAsync(() -> {
            ConsolePrinter.printlnCyan(LocalDateTime.now() + " execute task ...");
            return 1;
        }).thenRun(() -> log.info("schedule task type end ", type()));
    }
}
