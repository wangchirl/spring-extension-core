package com.shadow.extension24_condition.ex;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class CustomerCondition  implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String[] profiles = context.getEnvironment().getActiveProfiles();
        return Arrays.toString(profiles).contains("dev");
    }
}
