package com.shadow.schedule_task;

import com.shadow.schedule_task.support.CronTriggerSupport;
import com.shadow.utils.ConsolePrinter;
import com.shadow.utils.YamlUtils;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class TestTriggerTask extends CronTriggerSupport implements Runnable {

    private CronTrigger trigger =
            new CronTrigger((String) YamlUtils.getValueByKey("test.task.cron"));

    private final String TASK_TYPE = "test";

    @Override
    public String type() {
        return TASK_TYPE;
    }

    @Override
    public Runnable getTask() {
        return this;
    }

    @Override
    public CronTrigger getTrigger() {
        return trigger;
    }

    @Override
    public CronTrigger setTrigger(String newCron) {
        String oldCron = trigger.getExpression();
        this.trigger = new CronTrigger(newCron);
        log.info("update cron old {} to new {} ", oldCron, newCron);
        return this.trigger;
    }

    @Override
    @SchedulerLock(name = TASK_TYPE, lockAtLeastFor = "2000")
    public void run() {
        log.info("schedule task type {} start ", TASK_TYPE );
        CompletableFuture.supplyAsync(() -> {
            ConsolePrinter.printlnCyan("execute task ...");
            return 1;
        }).thenRun(() -> log.info("schedule task type end ", type()));
    }
}
