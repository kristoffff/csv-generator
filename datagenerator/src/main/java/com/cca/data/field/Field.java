package com.cca.data.field;

public interface Field<T> {
    String getName();

    T generateValue();

    default String formatValue(T val){
        return val.toString();
    }

    default String getValue(){
        T value = generateValue();
        return formatValue(value);
    }

}
