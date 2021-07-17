package com.shadow.schedule_task.support;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.support.CronTrigger;


@Slf4j
public abstract class CronTriggerSupport implements ICronTriggerTask, ApplicationContextAware, InitializingBean, Runnable {

    private CronTrigger trigger;

    private ApplicationContext applicationContext;

    /**
     * cron expression name
     * @return name
     */
    protected abstract String cronExpressionName();

    protected ApplicationContext getApplicationContext() {
        return this.applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String cronExpression = this.applicationContext.getEnvironment().getProperty(cronExpressionName());
        if(StringUtils.isEmpty(cronExpression)) throw new RuntimeException("cron expression is not found");
        this.trigger = new CronTrigger(cronExpression);
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
    public String toString() {
        return "TriggerTask {" +
                "trigger = " + getTrigger() +
                "task name = " + this.type() +
                "cronTrigger = " + getTrigger().getExpression() +
                "}";
    }
}
