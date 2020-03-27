package Converter;

import AbstractTest.Exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExamConverter implements Converter<String, Exam> {
    @Override
    public Exam convert(String source) {
        String[] fields = source.split("\\|");
        try {
            return new Exam(fields[0], Short.parseShort(fields[1]),
                    Short.parseShort(fields[2]), new SimpleDateFormat("dd/MM/yyyy").parse(fields[3]),
                    fields[4]);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Cannot parse entered date: %s", fields[3]));
        }
    }
}