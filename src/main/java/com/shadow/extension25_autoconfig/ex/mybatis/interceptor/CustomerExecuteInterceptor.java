package com.shadow.extension25_autoconfig.ex.mybatis.interceptor;

import com.shadow.extension25_autoconfig.ex.mybatis.AutoSetDate;
import com.shadow.extension25_autoconfig.ex.mybatis.AutoSetOperator;
import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Properties;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
@Data
@Intercepts({@Signature(
        type = org.apache.ibatis.executor.Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
)})
public class CustomerExecuteInterceptor implements Interceptor {

    private static final String DEFAULT_CREATE_TIME = "createTime";
    private static final String DEFAULT_UPDATE_TIME = "updateTime";
    private static final String DEFAULT_CREATE_BY = "createBy";
    private static final String DEFAULT_UPDATE_BY = "updateBy";

    private Properties properties;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];

        // get sql
        SqlCommandType sqlCommandType = statement.getSqlCommandType();

        // get params
        Object parameter = invocation.getArgs()[1];

        if(parameter == null) return invocation.proceed();

        // get filed
        Field[] declaredFields = parameter.getClass().getDeclaredFields();
        if (parameter.getClass().getSuperclass() != null) {
            Field[] supperFileds = parameter.getClass().getSuperclass().getDeclaredFields();
            declaredFields = ArrayUtils.addAll(declaredFields, supperFileds);
        }
        // if mybatis plus
        boolean isPlugUpdate = parameter.getClass().getDeclaredAnnotations().length == 1
                && parameter.getClass().getDeclaredFields()[0].getName().equals("serialVersionUID");

        // compatibility mybatis plus update
        if (isPlugUpdate) {
            Map<String, Object> updateParam = (Map<String, Object>) parameter;
            Class<?> updateParamType = updateParam.get("param1").getClass();
            declaredFields = updateParamType.getDeclaredFields();
            if (updateParamType.getSuperclass() != null) {
                Field[] supperFileds = updateParamType.getSuperclass().getDeclaredFields();
                declaredFields = ArrayUtils.addAll(declaredFields, supperFileds);
            }
        }

        // set default
        for (Field field : declaredFields) {
            AutoSetDate autoSetDate = field.getAnnotation(AutoSetDate.class);
            AutoSetOperator autoSetOperator = field.getAnnotation(AutoSetOperator.class);
            String fieldName = field.getName();
            // insert
            if (SqlCommandType.INSERT.equals(sqlCommandType)) {
                field.setAccessible(true);
                switch (fieldName) {
                    case DEFAULT_CREATE_TIME:
                    case DEFAULT_UPDATE_TIME:
                        field.set(parameter, LocalDateTime.now());
                        break;
                    case DEFAULT_CREATE_BY:
                    case DEFAULT_UPDATE_BY:
                        field.set(parameter, CustomerThreadLocal.get().getId());
                        break;
                }
                handleAnnotation(parameter, field, autoSetDate, autoSetOperator);
            }
            // update
            if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
                field.setAccessible(true);
                switch (fieldName) {
                    case DEFAULT_CREATE_TIME:
                        field.set(parameter, LocalDateTime.now());
                        break;
                    case DEFAULT_UPDATE_BY:
                        field.set(parameter, CustomerThreadLocal.get().getId());
                        break;
                }
                handleAnnotation(parameter, field, autoSetDate, autoSetOperator);
            }

            // compatibility mybatis plus update
            if (isPlugUpdate) {
                Map<String, Object> updateParam = (Map<String, Object>) parameter;
                field.set(updateParam.get("param1"), LocalDateTime.now());
            } else {
                field.set(parameter, LocalDateTime.now());
            }
        }
        return invocation.proceed();
    }

    private void handleAnnotation(Object parameter, Field field, AutoSetDate autoSetDate,
                                  AutoSetOperator autoSetOperator) throws IllegalAccessException {
        if (autoSetDate != null) {
            String value = autoSetDate.value();
            String format = autoSetDate.format();
            if (StringUtils.isEmpty(value) || StringUtils.isEmpty(format)) {
                field.set(parameter, LocalDateTime.now());
            } else {
                field.set(parameter, LocalDateTime.parse(value, DateTimeFormatter.ofPattern(format)));
            }
        }
        if(autoSetOperator != null) {
            String value = autoSetOperator.value();
            if(StringUtils.isEmpty(value)) {
                field.set(parameter, CustomerThreadLocal.get().getId());
            } else {
                field.set(parameter, value);
            }
        }
    }

    @Override
    public Object plugin(Object o) {
        if (o instanceof org.apache.ibatis.executor.Executor) {
            return Plugin.wrap(o, this);
        }
        return o;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
