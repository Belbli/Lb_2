package converter;

import abstractTest.DriveExam;
import abstractTest.FinalExam;
import exeption.ConverterParseExeption;

import java.text.SimpleDateFormat;

public class DriveExamConverter implements Converter<String, DriveExam> {
    @Override
    public DriveExam convert(String source) {
        String[] fields = source.split("\\|");
        try {
            return new DriveExam(fields[0], Short.parseShort(fields[1]),
                    Short.parseShort(fields[2]), new SimpleDateFormat("dd/MM/yyyy").parse(fields[3]),
                    fields[4]);
        } catch (Exception e) {
            throw new ConverterParseExeption(String.format("Can not parse next string : ", source));
        }
    }
}
