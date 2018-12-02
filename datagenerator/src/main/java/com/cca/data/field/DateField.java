package com.cca.data.field;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateField implements Field<LocalDate>{

    public final static DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("YYYYMMdd");

    private LocalDate minDate;
    private LocalDate maxDate;
    private String name;
    private DateTimeFormatter format;

    public DateField(String name){
        this(name, DEFAULT_FORMAT);
    }

    public DateField(String name, DateTimeFormatter format){
        this(name, DEFAULT_FORMAT, LocalDate.of(2000,1,1),LocalDate.now());
    }


    public DateField(String name, LocalDate minDate, LocalDate maxDate){
        this(name, DEFAULT_FORMAT, minDate, maxDate);
    }

    public DateField(String name, DateTimeFormatter format, LocalDate minDate, LocalDate maxDate){
        this.format = format;
        this.name = name;
        this.minDate = minDate;
        this.maxDate = maxDate;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate generateValue() {
        long duration = ChronoUnit.DAYS.between(minDate, maxDate);
        long randomFromStart = (long) (duration* Math.random());
        return minDate.plusDays(randomFromStart);
    }

    @Override
    public String formatValue(LocalDate val){
        return val.format(format);
    }


}
