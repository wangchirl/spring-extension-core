package com.shadow.schedule_task.controller;

import com.shadow.schedule_task.constants.ScheduleTaskInfoEnum;
import com.shadow.schedule_task.dto.RequestBodyDTO;
import com.shadow.schedule_task.res.R;
import com.shadow.schedule_task.support.CommonSchedulingConfigurer;
import com.shadow.schedule_task.support.ICronTriggerTask;
import com.shadow.schedule_task.vo.ScheduleInfoVO;
import com.shadow.schedule_task.vo.ScheduleTaskInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/schedule/task")
@Slf4j
public class ScheduleTaskController {

    @Autowired
    private CommonSchedulingConfigurer commonSchedulingConfigurer;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * task list
     * @return list
     */
    @GetMapping("/list")
    public R list() {
        List<ScheduleTaskInfoVO> result = new ArrayList<>();
        for (ScheduleTaskInfoEnum taskInfoEnum : ScheduleTaskInfoEnum.values()) {
            ScheduleTaskInfoVO vo = new ScheduleTaskInfoVO();
            vo.setTaskName(taskInfoEnum.getTaskName()).setTaskKey(taskInfoEnum.getTaskKey());
            result.add(vo);
        }
        return R.ok().put("data", result);
    }

    /**
     * 定时任务需要注意锁的加锁时间间隔
     * {
     * 	"option":"update",
     * 	"type":"test",
     * 	"cron":"0/5 * * * * ?"
     * }
     */
    @PostMapping("/option")
    public R test(@RequestBody @Valid RequestBodyDTO requestBodyDTO) {
        Object res = null;
        switch (requestBodyDTO.getOption().toLowerCase()) {
            case "update":
                res = commonSchedulingConfigurer.update(requestBodyDTO.getTaskKey(), requestBodyDTO.getCronExpression());
                break;
            case "cancel":
            case "delete":
                res = commonSchedulingConfigurer.cancel(requestBodyDTO.getTaskKey());
                break;
            case "restart":
            case "reload":
                res = commonSchedulingConfigurer.restart(requestBodyDTO.getTaskKey());
                break;
            case "add":
                String beanName = ScheduleTaskInfoEnum.getScheduleTaskBeanNameByTaskKey(requestBodyDTO.getTaskKey());
                if(!StringUtils.isEmpty(beanName)) {
                    try {
                        ICronTriggerTask triggerTask = this.applicationContext.getBean(beanName, ICronTriggerTask.class);
                        triggerTask.setTrigger(this.applicationContext.getEnvironment().getProperty(ScheduleTaskInfoEnum.getScheduleTaskCronNameByTaskKey(requestBodyDTO.getTaskKey())));
                        if(!StringUtils.isEmpty(requestBodyDTO.getCronExpression())) triggerTask.setTrigger(requestBodyDTO.getCronExpression());
                        res = commonSchedulingConfigurer.add(triggerTask);
                    } catch (Exception e) {
                        log.error("add schedule task error {} ", e.getMessage(), e);
                    }
                }
                break;
            default:
                res = commonSchedulingConfigurer.get(requestBodyDTO.getTaskKey());
                break;
        }
        return R.ok().put("data", res);
    }

}
