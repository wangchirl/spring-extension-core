package com.shadow.schedule_task;

import com.shadow.extension25_autoconfig.ex.annotation.EnableAutoDynamicDatasource;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAutoDynamicDatasource
@EnableSchedulerLock(defaultLockAtMostFor = "PT300S")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
