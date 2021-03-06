package converter;

import abstractTest.FinalExam;
import exeption.ConverterParseExeption;

import java.text.SimpleDateFormat;

public class FinalExamConverter implements Converter<String, FinalExam> {
    @Override
    public FinalExam convert(String source) {
        String[] fields = source.split("\\|");
        try {
            return new FinalExam(fields[0], Short.parseShort(fields[1]),
                    Short.parseShort(fields[2]), new SimpleDateFormat("dd/MM/yyyy").parse(fields[3]),
                    fields[4], Boolean.parseBoolean(fields[5]));
        } catch (Exception e) {
            throw new ConverterParseExeption(String.format("Can not parse next string : ", source));
        }
    }
}

