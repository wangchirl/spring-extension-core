package com.shadow.extension03_editor_xml.ex;

import com.shadow.extension03_editor_xml.test.Address;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class AddressPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(Address.class, new AddressPropertyEditor());
    }
}
