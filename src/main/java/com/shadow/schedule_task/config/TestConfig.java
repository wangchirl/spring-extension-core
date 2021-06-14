package com.shadow.schedule_task.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbc.JdbcLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.sql.DataSource;

@Configuration
public class TestConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    /**
     * CREATE TABLE shedlock(
     *     name VARCHAR(64),
     *     lock_until TIMESTAMP(3) NULL,
     *     locked_at TIMESTAMP(3) NULL,
     *     locked_by  VARCHAR(255),
     *     PRIMARY KEY (name)
     * )
     */
    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcLockProvider(dataSource);
    }

}
