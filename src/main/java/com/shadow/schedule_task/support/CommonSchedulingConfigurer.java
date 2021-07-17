package com.shadow.schedule_task.support;

import com.alibaba.fastjson.JSON;
import com.shadow.schedule_task.constants.ScheduleTaskInfoEnum;
import com.shadow.schedule_task.vo.ScheduleInfoVO;
import com.shadow.schedule_task.vo.ScheduleVO;
import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Slf4j
@Component
public class CommonSchedulingConfigurer implements SchedulingConfigurer, ApplicationContextAware, InitializingBean, DisposableBean {

    public CommonSchedulingConfigurer(Collection<ICronTriggerTask> cronTriggerTasks) {
        this.cronTriggerTasks = cronTriggerTasks;
    }

    /**
     * collections for futures of running tasks
     */
    private static final Map<String, ScheduledFuture> FUTURE_MAP = new ConcurrentHashMap<>(16);

    /**
     * collections for schedule task, for restart / update task
     */
    private static final Map<String, ICronTriggerTask> TASK_MAP = new ConcurrentHashMap<>(16);

    /**
     * CronTriggerTask collection
     */
    private Collection<ICronTriggerTask> cronTriggerTasks;

    /**
     * Spring IOC
     */
    private ApplicationContext applicationContext;

    /**
     * TaskScheduler ->  ThreadPoolTaskScheduler
     */
    private TaskScheduler taskScheduler;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskScheduler);
        if (null != cronTriggerTasks && !cronTriggerTasks.isEmpty()) {
            for (ICronTriggerTask triggerTask : cronTriggerTasks) {
                ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(triggerTask.getTask(), triggerTask.getTrigger());
                FUTURE_MAP.put(triggerTask.type(), scheduledFuture);
                TASK_MAP.put(triggerTask.type(), triggerTask);
            }
        }
    }

    /**
     * get task information
     * @return information
     */
    public ScheduleVO get(String taskKey) {
        ScheduleVO scheduleVO = new ScheduleVO();
        if(StringUtils.isEmpty(taskKey)) {
            final Set<String> types = FUTURE_MAP.keySet();
            scheduleVO.setActiveTaskKeys(types);
            List<ScheduleInfoVO> taskInfos = new ArrayList<>();
            for (Map.Entry<String, ICronTriggerTask> taskEntry : TASK_MAP.entrySet()) {
                ScheduleInfoVO scheduleInfoVO = new ScheduleInfoVO();
                scheduleInfoVO.setTaskName(ScheduleTaskInfoEnum.getScheduleTaskNameByTaskKey(taskEntry.getKey()))
                              .setTaskKey(taskEntry.getKey())
                              .setTaskCron(taskEntry.getValue().getTrigger().getExpression());
                taskInfos.add(scheduleInfoVO);
            }
            scheduleVO.setTasks(taskInfos);
        } else {
            final ICronTriggerTask triggerTask = TASK_MAP.get(taskKey);
            if(triggerTask != null) {
                ScheduleInfoVO scheduleInfoVO = new ScheduleInfoVO();
                scheduleInfoVO.setTaskName(ScheduleTaskInfoEnum.getScheduleTaskNameByTaskKey(taskKey))
                              .setTaskKey(taskKey)
                              .setTaskCron(triggerTask.getTrigger().getExpression());
                scheduleVO.setTasks(Collections.singletonList(scheduleInfoVO));
            }
        }
        return scheduleVO;
    }

    /**
     * add a new task
     * @param triggerTask task
     * @return boolean
     */
    public boolean add(@NotNull ICronTriggerTask triggerTask) {
        String type = triggerTask.type(), cron = triggerTask.getTrigger().getExpression();
        if(FUTURE_MAP.containsKey(type)) {
            log.warn("task type named {} already exists ", type);
            return false;
        }
        ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(triggerTask.getTask(), triggerTask.getTrigger());
        FUTURE_MAP.put(triggerTask.type(), scheduledFuture);
        TASK_MAP.put(triggerTask.type(), triggerTask);
        log.info("add task successful for type {}  cron {} ", type, cron);
        return true;
    }

    /**
     * update schedule task
     * @param type task type
     * @param cron cron expression
     * @return boolean
     */
    public boolean update(@NotNull final String type, @NotNull final String cron) {
        if(!FUTURE_MAP.containsKey(type)) {
            log.warn("task type named {} doesn't exist", type);
            return false;
        }
        cancel(type);
        ICronTriggerTask triggerTask = TASK_MAP.get(type);
        CronTrigger oldCronTrigger = triggerTask.getTrigger(), newCronTrigger = triggerTask.setTrigger(cron);
        ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(triggerTask.getTask(), newCronTrigger);
        FUTURE_MAP.put(type, scheduledFuture);
        log.info("update task successful for type {} old cron {} updated to new cron {}", type, oldCronTrigger, newCronTrigger);
        return true;
    }

    /**
     * cancel task
     * @param type task type
     * @return boolean
     */
    public boolean cancel(@NotNull  String type) {
        if(!FUTURE_MAP.containsKey(type)) {
            log.warn("task type named {} doesn't exists", type);
            return false;
        }
        ScheduledFuture scheduledFuture = FUTURE_MAP.get(type);
        if(null != scheduledFuture) {
            scheduledFuture.cancel(true);
        }
        FUTURE_MAP.remove(type);
        log.info("cancel task successful for type {} ", type);
        return true;
    }

    /**
     * restart task
     * @param type task type
     * @return boolean
     */
    public boolean restart(@NotNull String type) {
        ICronTriggerTask triggerTask = TASK_MAP.get(type);
        if(null == triggerTask) {
            log.warn("task type named {} doesn't exists ", type);
            return false;
        }
        cancel(type);
        ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(triggerTask.getTask(), triggerTask.getTrigger());
        FUTURE_MAP.put(type, scheduledFuture);
        log.info("restart task successful for type {} ", type);
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.taskScheduler = this.applicationContext.getBean(TaskScheduler.class);
    }

    @Override
    public void destroy() throws Exception {
        for (ScheduledFuture scheduledFuture : FUTURE_MAP.values()) {
            if(null != scheduledFuture) {
                scheduledFuture.cancel(true);
            }
        }
        FUTURE_MAP.clear();
        TASK_MAP.clear();
    }
}
