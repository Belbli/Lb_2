package converter;

import abstractTest.*;

public class TestConverterFactory {
    public static Converter<String, ? extends AbstractTest> getConverter(TestType converterType) {
        switch (converterType) {
            case EXAM:
                return new ExamConverter();
            case FINAL_EXAM:
                return new FinalExamConverter();
            case TEST:
                return new TestConverter();
            case DRIVE_EXAM:
                return new DriveExamConverter();
            default:
                throw new IllegalArgumentException("Wrong test converter type:" + converterType);
        }
    }
}
