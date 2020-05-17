package converter;


import abstractTest.Test;
import exeption.ConverterParseExeption;

import java.text.SimpleDateFormat;

public class TestConverter implements Converter<String, Test> {
    @Override
    public Test convert(String source) {
        String[] fields = source.split("\\|");
        try {
            return new Test(fields[0], Short.parseShort(fields[1]),
                    Short.parseShort(fields[2]),  new SimpleDateFormat("dd/MM/yyyy").parse(fields[3]),
                    Integer.parseInt(fields[4]));
        } catch (Exception e) {
            throw new ConverterParseExeption(String.format("Can not parse next string : ", source));
        }
    }
}

