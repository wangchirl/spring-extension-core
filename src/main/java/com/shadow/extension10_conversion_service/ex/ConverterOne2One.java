package com.shadow.extension10_conversion_service.ex;

import com.shadow.extension10_conversion_service.test.Son;
import org.springframework.core.convert.converter.Converter;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class ConverterOne2One implements Converter<String, Son> {
    @Override
    public Son convert(String source) {
        Son son = new Son();
        String[] props = source.split("-");
        son.setId(Integer.valueOf(props[0])).setName(props[1]);
        return son;
    }
}
