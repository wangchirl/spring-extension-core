package com.shadow.schedule_task.demo.constants;

public enum ScheduleTaskInfoEnum {

    TEST_NORMAL_TASK(ScheduleTaskNameConstants.TEST,
            "测试普通定时任务",
            ScheduleTaskNameConstants.TEST,
            "test.normal.task.cron"),
    TEST_DISTRIBUTION_TASK(ScheduleTaskNameConstants.TEST_DISTRIBUTION,
            "测试分布式定时任务",
            ScheduleTaskNameConstants.TEST_DISTRIBUTION,
            "test.distribution.task.cron"),
    ;

    // task unique key
    private String taskKey;
    // task name
    private String taskName;
    // spring bean name
    private String beanName;
    // cron expression name
    private String cronName;

    ScheduleTaskInfoEnum(String taskKey, String taskName, String beanName, String cronName) {
        this.taskKey = taskKey;
        this.taskName = taskName;
        this.beanName = beanName;
        this.cronName = cronName;
    }

    public static String getScheduleTaskBeanNameByTaskKey(String taskKey) {
        return getScheduleTaskInfoByTaskKey(taskKey, InnerTypeEnum.BEAN_NAME);
    }

    public static String getScheduleTaskNameByTaskKey(String taskKey) {
        return getScheduleTaskInfoByTaskKey(taskKey, InnerTypeEnum.TASK_NAME);
    }

    public static String getScheduleTaskCronNameByTaskKey(String taskKey) {
        return getScheduleTaskInfoByTaskKey(taskKey, InnerTypeEnum.TASK_CRON);
    }

    private static String getScheduleTaskInfoByTaskKey(String taskKey, InnerTypeEnum typeEnum) {
        for (ScheduleTaskInfoEnum taskInfoEnum : ScheduleTaskInfoEnum.values()) {
            if (taskInfoEnum.getTaskKey().equals(taskKey)) {
                switch (typeEnum) {
                    case BEAN_NAME:
                        return taskInfoEnum.getBeanName();
                    case TASK_NAME:
                        return taskInfoEnum.getTaskName();
                    case TASK_CRON:
                        return taskInfoEnum.getCronName();
                }
            }
        }
        return null;
    }


    // ========== getter =================

    public String getTaskKey() {
        return taskKey;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getBeanName() {
        return beanName;
    }


    public String getCronName() {
        return cronName;
    }

    // inner enum
    enum InnerTypeEnum {
        BEAN_NAME,
        TASK_NAME,
        TASK_CRON;
    }
}
