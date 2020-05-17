import abstractTest.*;
import io.FileReaderWriter;
import menu.Menu;
import exeption.ConverterParseExeption;
import exeption.TestTypeExeption;
import io.ReaderWriter;

import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Date date = new Date();

        Test test = new Test("OOP", (short) 120, (short) 10, date, 3);
        Test test2 = new Test("OOP", (short) 120, (short) 9, date, 3);
        FinalExam finalExam = new FinalExam("OOP", (short) 90, (short) 9, date, "Glyhova", true);
        FinalExam finalExam1 = new FinalExam(finalExam);
        Exam exam1 = new Exam("KSIS", (short) 120, (short) 8, date,"Rysetckiyy");
        Test test1 = new Test("POASYTP", (short) 20, (short) 9, date, 20);
        FinalExam finalExam2 = new FinalExam("POASYTP", (short) 120, (short) 8, date, "Kravchenko", false);
        Exam exam2 = new Exam("Math", (short) 180, (short) 9, date, "Golybeva");
        Exam exam3 = new Exam("OAiP", (short) 90, (short) 10, date, "Oskin");

        List<AbstractTest> at = new ArrayList<>();
        at.add(exam1);

        FileOutputStream out = new FileOutputStream("data3.json");
        try(ObjectOutputStream objOut = new ObjectOutputStream(out)){

            objOut.writeObject(exam1);
            objOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //exam1.readFromJSON("1234.json");

//Math|180|10|07/07/2018|Examiner
        /*List<AbstractTest> testList = new ArrayList();
        List<AbstractTest> testList2 = new ArrayList();

        testList.add(test);
        testList.add(test1);
        testList.add(test2);
        testList.add(exam1);
        testList.add(exam2);
        testList.add(exam3);
        testList.add(finalExam);
        testList.add(finalExam1);
        testList.add(finalExam2);
        

        String[] menu = {
                "1.Display collection",
                "2.Add element",
                "3.Sort collection",
                "4.Search",
                "5.Save to file",
                "6.Load from file",
                "7.Exit"
        };

        String[] addMenuItems = {
                "1.Exam",
                "2.Test",
                "3.Final Exam",
                "4.Drive Exam",
                "5.Exit"
        };

        String[] sortDirection = {
                "1.Min-Max",
                "2.Max-Min"
        };

        String[] sortField = {
                "1.Sort by subject",
                "2.Sort by duration",
                "3.Sort by mark"
        };

        Menu mainMenu = new Menu(menu);
        Menu addMenu = new Menu(addMenuItems);
        Menu sortDirectionMenu = new Menu(sortDirection);
        Menu sortFieldMenu = new Menu(sortField);

        ReaderWriter rw = new ReaderWriter();


        int operation = 0;

        while(operation != 7){
            operation = mainMenu.displayMenu();
            switch (operation){
                case 1:
                    for(AbstractTest it: testList) {
                        System.out.println(it + "\n");
                    }
                    break;
                case 2:
                    int menuItem = 0;
                    while (menuItem < addMenuItems.length) {
                        TestType inputType = null;
                        System.out.println("Choose adding test type (1-4)");
                        menuItem = addMenu.displayMenu();
                        switch (menuItem) {
                            case 1:
                                inputType = TestType.resolve("exam");
                                break;
                            case 2:
                                inputType = TestType.resolve("test");
                                break;
                            case 3:
                                inputType = TestType.resolve("final exam");
                                break;
                            case 4:
                                inputType = TestType.resolve("drive exam");
                            default:
                                break;
                        }
                       if(inputType != null) {
                           try {
                               testList.add(rw.read(inputType));
                           } catch (ConverterParseExeption e) {
                               System.err.println("Check your input data");
                           }
                       }
                    }
                    break;
                case 3:
                    int direction = 0;
                    while (direction == 0){
                        System.out.println("Choose sort direction (1-2)");
                        direction = sortDirectionMenu.displayMenu();
                    }
                    int field = 0;
                    while (field == 0) {
                        System.out.println("Choose sort field (1-3)");
                        field = sortFieldMenu.displayMenu();
                        switch (field) {
                            case 1:
                                if(direction == 1) {
                                    testList.sort((x, y) -> x.getSubject().compareTo(y.getSubject()));
                                } else {
                                    testList.sort((x, y) -> y.getSubject().compareTo(x.getSubject()));
                                }
                                break;
                            case 2:
                                if(direction == 1) {
                                    testList.sort((x, y) -> x.getDuration() - y.getDuration());
                                } else {
                                    testList.sort((x, y) -> y.getDuration() - x.getDuration());
                                }
                                break;
                            case 3:
                                if(direction == 1) {
                                    testList.sort((x, y) -> x.getMark() - y.getMark());
                                } else {
                                    testList.sort((x, y) -> y.getMark() - x.getMark());
                                }
                                break;
                            default:
                                break;
                        }
                    }
                   // testList.sort(AbstractTest::compare2);
                    //testList.sort((x, y) -> y.compare2(x));
                    System.out.println(testList);
                    break;
                case 4:
                    int searchMenuItem = 0;
                    while (searchMenuItem < addMenuItems.length) {
                        TestType searchType = null;
                        System.out.println("Choose searching test type (1-3)");
                        searchMenuItem = addMenu.displayMenu();
                        switch (searchMenuItem) {
                            case 1:
                                searchType = TestType.resolve("exam");
                                break;
                            case 2:
                                searchType = TestType.resolve("test");
                                break;
                            case 3:
                                searchType = TestType.resolve("final exam");
                                break;
                            default:
                                break;
                        }
                        if(searchType != null) {
                            try {
                                System.out.println(testList.contains(rw.read(searchType)));
                            } catch (TestTypeExeption e) {
                                System.err.println("Check your input data");
                            }
                        }
                    }

                    break;
                case 5:
                    try {
                        new FileReaderWriter().write(testList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        testList2 = new FileReaderWriter().read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(testList2);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }*/

    }
}



class TaskA {
    public static long countFilesWithExtension(String catalog, String extension) {
        File file = new File(catalog);
        long count = Arrays.stream(file.list())
                .filter(f -> f.substring(f.lastIndexOf('.')+1).equals(extension))
                .count();


        return count;
    }
}
