package com.shadow.extension03_editor_xml.ex;

import com.shadow.extension03_editor_xml.test.Address;

import java.beans.PropertyEditorSupport;

/**
 * @author shadow
 * @create 2021-02-10
 * @description
 */
public class AddressPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] props = text.split("-");
        Address address = new Address();
        address.setProvince(props[0]).setCity(props[1]).setTown(props[2]);
        // 记得调用
        setValue(address);
    }
}
