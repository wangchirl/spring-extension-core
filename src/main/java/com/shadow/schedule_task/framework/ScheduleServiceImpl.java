package com.shadow.schedule_task.framework;

import com.shadow.schedule_task.demo.constants.ScheduleTaskNameConstants;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public void consumer(Consumer<String> consumer) {
        String params = ScheduleService.JOB_PARAMETERS_THREAD_LOCAL.get();
        consumer.accept(params);
    }

    @Override
    public <T> T supplier(Supplier<T> supplier) {
        return supplier.get();
    }

    @Override
    public <T> T function(Function<String, T> function) {
        String params = ScheduleService.JOB_PARAMETERS_THREAD_LOCAL.get();
        return function.apply(params);
    }

    @Override
    public Integer test(String params) {
        log.info("params : {} " , params);
        return 1024;
    }

    @Override
    @SchedulerLock(name = ScheduleTaskNameConstants.TEST_DISTRIBUTION, lockAtLeastFor = "30000")
    public Integer testDis(String params) {
        log.info("params : {} " , params);
        return 1024;
    }
}
