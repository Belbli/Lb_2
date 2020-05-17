package converter;

import abstractTest.Exam;
import exeption.ConverterParseExeption;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ExamConverter implements Converter<String, Exam> {
    @Override
    public Exam convert(String source) {
        String[] fields = source.split("\\|");
        try {
            return new Exam(fields[0], Short.parseShort(fields[1]),
                    Short.parseShort(fields[2]), new SimpleDateFormat("dd/MM/yyyy").parse(fields[3]),
                    fields[4]);
        } catch (Exception e) {
            throw new ConverterParseExeption("Can not parse next string : "+ Arrays.toString(fields));
        }
    }
}