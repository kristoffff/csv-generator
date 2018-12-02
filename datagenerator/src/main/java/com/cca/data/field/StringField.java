package com.cca.data.field;

import java.util.List;

public class StringField implements Field<String> {

    private String name;
    private List<String> possibleValues;

    public StringField(String name, List<String> possibleValues){
        this.name = name;
        this.possibleValues = possibleValues;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String generateValue() {
        int index = (int) (possibleValues.size() * Math.random());
        return possibleValues.get(index);
    }
}
