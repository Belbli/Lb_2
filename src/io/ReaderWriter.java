package io;

import abstractTest.AbstractTest;
import abstractTest.TestType;
import converter.Converter;
import converter.TestConverterFactory;
import java.io.PrintStream;
import java.util.Scanner;

public class ReaderWriter {
    private Scanner reader;
    private PrintStream writer;

    public ReaderWriter() {
        reader = new Scanner(System.in);
        writer = System.out;
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractTest> T read(TestType testType) {
        System.out.println("Enter test info: ");
        String line = reader.nextLine();
        return ((Converter<String, T>) TestConverterFactory.getConverter(testType)).convert(line);
    }

    public void print(AbstractTest test) {
        writer.println(test);
    }
}
