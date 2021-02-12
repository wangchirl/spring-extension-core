package com.shadow.extension04_editor_annotation.config;

import com.shadow.extension04_editor_annotation.ex.PetPropertyEditor;
import com.shadow.extension04_editor_annotation.ex.PetPropertyEditorRegistrar;
import com.shadow.extension04_editor_annotation.test.Human;
import com.shadow.extension04_editor_annotation.test.Pet;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Collections;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
@Configuration
@PropertySource("classpath:extension04.properties")
public class CustomerConfiguration {

    @Bean
    public Human human() {
        return new Human();
    }

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        // 方式一 setPropertyEditorRegistrars
        // configurer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{new PetPropertyEditorRegistrar()});
        // 方式二
        configurer.setCustomEditors(Collections.singletonMap(Pet.class, PetPropertyEditor.class));
        return configurer;
    }

}
