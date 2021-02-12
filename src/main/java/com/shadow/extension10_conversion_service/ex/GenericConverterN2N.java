package com.shadow.extension10_conversion_service.ex;

import com.shadow.extension10_conversion_service.test.Addr;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class GenericConverterN2N implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(Collection.class, Object[].class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(source == null) {// value
            return null;
        }
        Collection<?> sourceCollections = (Collection<?>) source;
        int size = sourceCollections.size();
        Addr[] addrs = new Addr[size];
        int i = 0;
        for (Object element : sourceCollections) {
            String[] props = element.toString().split("-");
            Addr addr = new Addr();
            addr.setProvince(props[0]);
            addr.setCity(props[1]);
            addr.setTown(props[2]);
            addrs[i++] = addr;
        }
        return addrs;
    }
}
