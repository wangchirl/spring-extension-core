package com.shadow.extension11_depends_on.ex;

import com.shadow.extension11_depends_on.test.C;
import com.shadow.extension11_depends_on.test.D;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Configuration
public class DependsOnConfig {

    @Bean
    @DependsOn(value = {"d"})
    public C c() {
        return new C();
    }

    @Bean
    public D d() {
        return new D();
    }
}
