import AbstractTest.*;
import Converter.TestConverterFactory;
import list.LinkedList;

import java.text.ParseException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static int search(List<AbstractTest> list, AbstractTest at){
        int index = 0;
        for (AbstractTest it : list){
            if(it.equals(at)) {
                System.out.println("Founded! Index = " + index + ":\n" + it);
                return index;
            }
            index++;
        }
        System.out.println("Not founded(");
        return -1;
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        Test test = new Test("OOP", (short) 120, (short) 10, date, 3);
        Test test2 = new Test("OOP", (short) 120, (short) 9, date, 3);
        //Exam exam = new Exam();
        FinalExam finalExam = new FinalExam("OOP", (short) 90, (short) 9, date, "Glyhova", true);
        FinalExam finalExam1 = new FinalExam(finalExam);
        Exam exam1 = new Exam("KSIS", (short) 120, (short) 8, date,"Rysetckiyy");
        Test test1 = new Test("POASYTP", (short) 20, (short) 9, date, 20);
        FinalExam finalExam2 = new FinalExam("POASYTP", (short) 120, (short) 8, date, "Kravchenko", false);
        Exam exam2 = new Exam("Math", (short) 180, (short) 9, date, "Golybeva");
        Exam exam3 = new Exam("OAiP", (short) 90, (short) 10, date, "Oskin");
       /* System.out.println(finalExam.equals(finalExam1));
        System.out.println(test.equals(test2) + "\n" + test2.equals(test) + "\n" + AbstractTest.objectsCreatedCount);

        List<AbstractTest> tests = new ArrayList<>();
        tests.add(test);
        tests.add(test2);
        tests.add(exam);
        tests.add(finalExam);
        tests.add(finalExam1);
        tests.add(exam1);
        tests.add(test1);
        tests.add(finalExam2);
        tests.add(exam2);
        tests.add(exam3);


        search(tests, exam2);

        System.out.println(tests);
        Scanner scanner = new Scanner(System.in);
        String buff;
        String type;
        System.out.println("\nEnter type of test: ");
        while (!(type = scanner.nextLine()).isEmpty()){
            System.out.println("Enter test info: ");
            buff = scanner.nextLine();
            AbstractTest convert = TestConverterFactory.getConverter(type).convert(buff);
            tests.add(convert);
            System.out.println("\nEnter type of test: ");
        }

        scanner.close();
        System.out.println(tests);*/

        LinkedList<AbstractTest> tests = new LinkedList<>();
        tests.add(test);
        tests.add(test2);

        tests.add(finalExam);
        tests.add(finalExam1);
        tests.add(exam1);
        tests.add(test1);
        tests.add(finalExam2);
        tests.add(exam2);
        tests.add(exam3);
        /*for (int i = 10; i < 20; i++) {
            list.add(i);
        }*/
        //list.add(0, 1000);
        //list.delete(0);
        //System.out.println(list.getLast());
        //list.deleteAll();
        //list.changeByIndex(0, 100);

        /*System.out.println(tests);
        tests.swap(tests.getByIndex(0), tests.getByIndex(1));
        System.out.println(tests);*/

        Map <String, BiFunction<? extends AbstractTest, ? extends AbstractTest, Integer>> sortMapping = new HashMap<>();
        BiFunction<AbstractTest, AbstractTest, Integer> subjectSort = (left, right) -> left.getSubject().compareTo(right.getSubject());
        BiFunction<AbstractTest, AbstractTest, Integer> durationSort = (left, right) -> left.getDuration() - right.getDuration();
        BiFunction<AbstractTest, AbstractTest, Integer> markSort = (left, right) -> left.getMark() - right.getMark();
        BiFunction<AbstractTest, AbstractTest, Integer> dateSort = (left, right) -> left.getDate().compareTo(right.getDate());
        BiFunction<Test, Test, Integer> numOfQuestionsSort = (left, right) -> left.getNumberOfQuestions() - right.getNumberOfQuestions();
        BiFunction<Exam, Exam, Integer> examinerSort = (left, right) -> left.getExaminer().compareTo(right.getExaminer());

        sortMapping.put("subjectSort", subjectSort);
        sortMapping.put("durationSort", durationSort);
        sortMapping.put("markSort", markSort);
        sortMapping.put("dateSort", dateSort);
        sortMapping.put("numOfQuestionsSort", numOfQuestionsSort);
        sortMapping.put("examinerSort", examinerSort);

        System.out.println(tests.getByIndex(0));
        tests = tests.sort(tests, subjectSort);
       // System.out.println(tests.getByIndex(0) + "\n" + test);
        //tests.swap(tests.getByIndex(0), tests.getByIndex(1));
      //  System.out.println(tests);

    }
}
