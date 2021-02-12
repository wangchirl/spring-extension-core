package com.shadow.extension10_conversion_service.ex;

import com.shadow.extension10_conversion_service.test.HumanEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
public class ConverterFactoryOne2N implements ConverterFactory<String, Enum> {
    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> aClass) {
        return new StringToEnum(HumanEnum.class);
    }
    // 内部类的实现
    // 把 Integer 转为 Enum 的子类型
    // 相当于根据 Integer 找到一个 Enum（注意此处根据角标来找的）
    private class StringToEnum<T extends Enum> implements Converter<String, T> {
        private final Class<T> enumType;

        public StringToEnum(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(String source) {
            return (T) Enum.valueOf(enumType, source.trim());
        }
    }
}
