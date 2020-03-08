import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestConverter implements Converter<String, Test> {
    @Override
    public Test convert(String source) {
        String[] fields = source.split("\\|");
        try {
            return new Test(fields[0], Short.parseShort(fields[1]),
                    Short.parseShort(fields[2]), Integer.parseInt(fields[3]),
                    new SimpleDateFormat("dd/MM/yyyy").parse(fields[4]));
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Cannot parse entered date: %s", fields[4]));
        }
    }
}
