import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TrialConverter {
    public AbstractTest stringToExam(String str) throws ParseException {
        String[] fields = str.split("\\|");
        return new Exam(fields[0], Short.parseShort(fields[1]),
                Short.parseShort(fields[2]), new SimpleDateFormat("dd/MM/yyyy").parse(fields[3]), fields[4]);
    }

    public AbstractTest stringToFinalExam(String str) throws ParseException {
        String[] fields = str.split("\\|");
        return new FinalExam(fields[0], Short.parseShort(fields[1]),
                Short.parseShort(fields[2]), new SimpleDateFormat("dd/MM/yyyy").parse(fields[3]),
                fields[4], Boolean.parseBoolean(fields[5]));
    }

    public AbstractTest stringToTest(String str) throws ParseException {
        String[] fields = str.split("\\|");
        return new Test(fields[0], Short.parseShort(fields[1]),
                Short.parseShort(fields[2]), Integer.parseInt(fields[3]), new SimpleDateFormat("dd/MM/yyyy").parse(fields[4]));
    }


}
