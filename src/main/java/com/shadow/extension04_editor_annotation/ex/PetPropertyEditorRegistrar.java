package com.shadow.extension04_editor_annotation.ex;

import com.shadow.extension04_editor_annotation.test.Pet;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class PetPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(Pet.class, new PetPropertyEditor());
    }
}
