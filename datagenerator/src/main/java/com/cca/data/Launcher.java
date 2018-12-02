package com.cca.data;

import com.cca.data.field.*;
import com.cca.data.generator.CSVGenerator;
import com.cca.data.generator.DocumentGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Launcher {

    public static void main(String[] args) throws IOException {
        Collection fields = new ArrayList<Field>();
        fields.add(new AutoIncrementField("id"));
        fields.add(new StringField("valeur", Arrays.asList("tutu","toto")));
        fields.add(new DateField("date"));
        fields.add(new LongField("size", 1l,10000l));
        fields.add(new DoubleField("amount", -1_000_000d,1_000_000d));

        DocumentGenerator generator = new CSVGenerator();
        generator.generateDocument("c:/tmp/test.csv",fields,100_000);
    }

}
