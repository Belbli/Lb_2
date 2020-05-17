package io;

import abstractTest.AbstractTest;
import abstractTest.Exam;
import abstractTest.Test;
import converter.*;
import exeption.ConverterParseExeption;

import java.io.*;
import java.util.List;

public class FileReaderWriter {


    public FileReaderWriter() throws FileNotFoundException {

    }

    public void write(List<? extends AbstractTest> list) throws IOException {
        FileOutputStream out = new FileOutputStream("data3.json");
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        /*for(AbstractTest it: list) {
            out.write(it.toString().getBytes());
            out.write("\n".getBytes());
        }*/

        objOut.writeObject(list);

        out.flush();
        out.close();
        objOut.flush();
        objOut.close();
    }

    public List<AbstractTest> read() throws IOException {
        List<AbstractTest> list = null;
        File inputFile = new File("data2.bin");
        byte[] data = new byte[128];
        FileInputStream fis = new FileInputStream(inputFile);

        ObjectInputStream objIs = new ObjectInputStream(fis);
        try {
            list = (List<AbstractTest>) objIs.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = fis.read()) != -1) {
            if(ch == ' '){
                ch = '|';
            }
            if(ch != '\n') {
                sb.append((char) ch);
            }

            if(ch == '\n') {
                System.out.println(sb);
                try {
                    list.add(new ExamConverter().convert(sb.toString()));
                } catch (ConverterParseExeption e1) {
                    try {
                        list.add(new TestConverter().convert(sb.toString()));
                    } catch (ConverterParseExeption e2) {
                        try {
                            list.add(new FinalExamConverter().convert(sb.toString()));
                        } catch (ConverterParseExeption e3) {
                            try {
                                list.add(new DriveExamConverter().convert(sb.toString()));
                            } catch (ConverterParseExeption e4){
                                e4.printStackTrace();
                            }
                        }
                    }
                }
                sb.delete(0, sb.length());
            }
        }*/
        fis.close();
        return list;
    }
}
