import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        Test test = new Test("OOP", (short) 120, (short) 10, 3, date);
        Test test2 = new Test("OOP", (short) 120, (short) 9, 3, date);
        Exam exam = new Exam();
        FinalExam finalExam = new FinalExam("OOP", (short) 90, (short) 9, date, "Glyhova", true);
        FinalExam finalExam1 = new FinalExam(finalExam);
        System.out.println(finalExam.equals(finalExam1));
        System.out.println(test.equals(test2) + "\n" + test2.equals(test) + "\n" + AbstractTest.objectsCreatedCount);

        List<AbstractTest> trials = new ArrayList<>();
        trials.add(test);
        trials.add(test2);
        trials.add(exam);
        trials.add(finalExam);
        trials.add(finalExam1);

        System.out.println(trials);

        /*Trial trial = trialFactory.getTrial("Exam", "OOP|100|10|10/06/2020|Teacher");
        System.out.println(trial);*/

        Scanner scanner = new Scanner(System.in);
        String buff;
        System.out.println("\nEnter trial info: ");
        while (!(buff = scanner.nextLine()).isEmpty()){
            System.out.println("Enter type of trial: ");
            String type = scanner.nextLine();
            AbstractTest convert = TestConverterFactory.getConverter(type).convert(buff);
            trials.add(convert);
        }

        scanner.close();
        System.out.println(trials);
    }
}
