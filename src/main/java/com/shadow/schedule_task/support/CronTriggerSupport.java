package com.shadow.schedule_task.support;

public abstract class CronTriggerSupport implements ICronTriggerTask {

    @Override
    public String type() {
        return this.getClass().getName().toLowerCase();
    }

    @Override
    public String toString() {
        return "TriggerTask {" +
                "type = " + type() +
                ", task = " + getTask() +
                "cronTrigger = " + getTrigger().getExpression() +
                "}";
    }
}
