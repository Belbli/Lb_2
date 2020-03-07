import java.text.ParseException;

public class TrialFactory {
    public Trial getTrial(String trialType, String trialInfo){
        switch (trialType){
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
                return new Test();
            default:
                throw new IllegalArgumentException("Wrong trial type:" + trialType);
        }
    }
}
