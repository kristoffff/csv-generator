package com.cca.data.generator;

import com.cca.data.field.Field;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;


public class CSVGenerator implements DocumentGenerator {

    private String separator = "|";


    @Override
    public void generateDocument(String path, Collection<Field> fields, long nbRows) throws IOException {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(buildHeader(fields) + "\r\n");
            for (int i = 0; i < nbRows; i++) {
                fw.write(buildRow(fields) + "\r\n");
            }
        }

    }

    private String buildHeader(Collection<Field> fields) {
        return fields.stream().map(Field::getName).collect(Collectors.joining(this.separator));
    }

    private String buildRow(Collection<Field> fields) {
        return fields.stream().map(Field::getValue).collect(Collectors.joining(this.separator));
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
