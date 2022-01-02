package com.shadow.schedule_task.demo.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbc.JdbcLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DistributionLockConfig {

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
