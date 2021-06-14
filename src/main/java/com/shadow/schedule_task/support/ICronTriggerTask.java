package com.shadow.schedule_task.support;

import org.springframework.scheduling.support.CronTrigger;

public interface ICronTriggerTask {

    /**
     * schedule task type
     */
    String type();

    /**
     * real task
     */
    Runnable getTask();

    /**
     * get cronTrigger
     */
    CronTrigger getTrigger();

    /**
     * for update trigger
     */
    CronTrigger setTrigger(String cron);
}
