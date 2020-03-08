public class TestConverterFactory{
    public static Converter<String, ? extends AbstractTest> getConverter(String converterType) {
        switch (converterType) {
            case "Exam":
                return new ExamConverter();
            case "FinalExam":
                return new FinalExamConverter();
            case "Test":
                return new TestConverter();
            default:
                throw new IllegalArgumentException("Wrong trial converter type:" + converterType);
        }
    }
}
