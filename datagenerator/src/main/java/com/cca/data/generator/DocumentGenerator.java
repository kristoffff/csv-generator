package com.cca.data.generator;

import com.cca.data.field.Field;

import java.io.IOException;
import java.util.Collection;

public interface DocumentGenerator {

    void generateDocument(String path, Collection<Field> fields, long nbRows) throws IOException;
}
