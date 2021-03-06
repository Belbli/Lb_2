package abstractTest;

import java.util.Date;
import java.util.Objects;

public class FinalExam extends Exam{
    private boolean isOral;

    public FinalExam(){
        objectsCreatedCount++;
    }

    public FinalExam(String subject, short duration, short mark, Date date, String examiner, boolean isOral) {
        super(subject, duration, mark, date, examiner);
        this.isOral = isOral;
    }

    public FinalExam(FinalExam finalExam){
        super(finalExam);
        this.isOral = finalExam.isOral;
    }

    public boolean isOral() {
        return isOral;
    }

    public void setOral(boolean oral) {
        isOral = oral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FinalExam finalExam = (FinalExam) o;
        return isOral == finalExam.isOral &&
                super.equals(finalExam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOral);
    }

    @Override
    public String toString() {
        return super.toString() + " " + isOral;
    }

    @Override
    public int compare(AbstractTest o) {
        FinalExam test = (FinalExam) o;
        return this.getSubject().compareTo(test.getSubject());
    }

    public int compare2(AbstractTest o){
        //FinalExam test = (FinalExam) o;
        if(this.getClass().getName().compareTo(o.getClass().getName()) == 0) {
            return this.getSubject().compareTo(((FinalExam) o).getSubject());
        }
        else return this.getClass().getName().compareTo(o.getClass().getName());
    }
}
