package com.shadow.schedule_task.framework.aop;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface SimpleJob {

    /**
     * job name / type
     */
    String value() default "";

}
