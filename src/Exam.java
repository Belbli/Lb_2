import java.util.Date;
import java.util.Objects;

public class Exam extends Trial{
    private String examiner;

    public Exam(){
        objectsCreatedCount++;
    }

    public Exam(String subject, short duration, short mark, Date date, String examiner) {
        super(subject, duration, mark, date);
        this.examiner = examiner;
    }

    public Exam(Exam exam){
        super(exam);
        this.examiner = exam.examiner;
    }

    public String getExaminer() {
        return examiner;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Exam exam = (Exam) o;
        return examiner == exam.examiner &&
                super.equals(exam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), examiner);
    }

    @Override
    public String toString() {
        return super.toString() + "Exam{" +
                "examiner='" + examiner + '\'' +
                '}' + '\n';
    }
}
