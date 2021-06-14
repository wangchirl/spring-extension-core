package com.shadow.schedule_task.controller;

import com.shadow.schedule_task.TestTriggerTask;
import com.shadow.schedule_task.dto.RequestBodyDTO;
import com.shadow.schedule_task.support.CommonSchedulingConfigurer;
import com.shadow.schedule_task.support.ICronTriggerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    @Autowired
    private CommonSchedulingConfigurer commonSchedulingConfigurer;

    @Autowired
    private TestTriggerTask testTriggerTask;

    /**
     * 定时任务需要注意锁的加锁时间间隔
     * {
     * 	"option":"update",
     * 	"type":"test",
     * 	"cron":"0/5 * * * * ?"
     * }
     */
    @PostMapping("/schedule/option")
    public Object test(@RequestBody @Valid RequestBodyDTO requestBodyDTO) {
        Object res = null;
        switch (requestBodyDTO.getOption().toLowerCase()) {
            case "update":
                res = commonSchedulingConfigurer.update(requestBodyDTO.getType(), requestBodyDTO.getCron());
                break;
            case "cancel":
            case "delete":
                res = commonSchedulingConfigurer.cancel(requestBodyDTO.getType());
                break;
            case "restart":
            case "reload":
                res = commonSchedulingConfigurer.restart(requestBodyDTO.getType());
                break;
            case "add":
                ICronTriggerTask triggerTask = null;
                if(requestBodyDTO.getType().equals("test")) {
                    triggerTask = testTriggerTask;
                }
                if(triggerTask != null)
                    res = commonSchedulingConfigurer.add(triggerTask);
                break;
            default:
                res = commonSchedulingConfigurer.get();
                break;
        }
        return res;
    }

}
