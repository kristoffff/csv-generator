package com.cca.data.field;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DoubleField implements Field<Double> {

    public static final String DEFAULT_FORMAT = "#0.00";

    private String name;
    private Double min;
    private Double max;
    private NumberFormat formatter;


    public DoubleField(String name, Double min, Double max) {
        this(name, min, max, DEFAULT_FORMAT);
    }

    public DoubleField(String name, Double min, Double max, String format) {
        this.name = name;
        this.formatter = new DecimalFormat(format);
        this.min = min;
        this.max = max;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double generateValue() {
        return ((max - min) * Math.random() + min);
    }

    @Override
    public String formatValue(Double val) {
        return formatter.format(val);
    }
}
