package com.cca.data.field;

public class LongField implements Field<Long> {

    private String name;
    private Long min;
    private Long max;


    public LongField(String name, Long min, Long max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Long generateValue() {
        return (long) ((max-min) * Math.random() + min);
    }
}
