package com.cca.data.field;

import java.util.concurrent.atomic.AtomicLong;

public class AutoIncrementField implements Field<Long> {

    private String name;
    private AtomicLong index;

    public AutoIncrementField(String name) {
        this(name,1l);
    }


    public AutoIncrementField(String name, long initialValue) {
        this.name = name;
        this.index = new AtomicLong(initialValue);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Long generateValue() {
        return index.getAndIncrement();
    }
}
