import java.text.ParseException;

public class TrialFactory {
    public static AbstractTest getTrial(String trialType, String trialInfo) {
        switch (trialType) {
            case "Exam":
                try {
                    return new TrialConverter().stringToExam(trialInfo);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            case "FinalExam":
                try {
                    return new TrialConverter().stringToFinalExam(trialInfo);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            case "Test":
                try {
                    return new TrialConverter().stringToTest(trialInfo);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            default:
                throw new IllegalArgumentException("Wrong trial type:" + trialType);
        }
    }
}
