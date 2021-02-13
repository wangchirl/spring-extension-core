package com.shadow.extension25_autoconfig.ex.properties;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Data
@Accessors(chain = true)
public class DatasourceProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    /**
     * HikariDatasource
     */
    private int connectionTimeout = 6000;
    private int validationTimeout = 6000;
    private int idleTimeout = 60000;
    private int maxLifetime = 30000;
    private int maximumPoolSize = 10;
    private int minimumIdle = 10;
    private String connectionTestQuery = "SELECT 1";

    /**
     * DruidDatasource
     */
    private int initialSize = 2;
    private int maxActive = 10;
    private int minIdle = -1;
    private long maxWait = 60 * 1000L;
    private long timeBetweenEvictionRunsMillis = 60 * 1000L;
    private long minEvictableIdleTimeMillis = 1000L * 60L * 30L;
    private long maxEvictableIdleTimeMillis = 1000L * 60L * 60L % 7;
    private String validationQuery = "SELECT 1";
    private int validationQueryTimeout = -1;
    private boolean testOnBorrow = false;
    private boolean testOnReturn = false;
    private boolean testWhileIdle = true;
    private boolean poolPreparedStatements = false;
    private int maxOpenPreparedStatements = -1;
    private boolean sharePreparedStatements = false;
    private String filters = "stat,wall";


}
