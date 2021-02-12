package com.shadow.extension04_editor_annotation.ex;

import com.shadow.extension04_editor_annotation.test.Pet;

import java.beans.PropertyEditorSupport;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class PetPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] props = text.split("_");
        Pet pet = new Pet();
        pet.setName(props[0]).setAge(Integer.valueOf(props[1])).setColor(props[2]);
        setValue(pet);
    }
}
