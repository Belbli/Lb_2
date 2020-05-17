package abstractTest;

import java.util.Date;
import java.util.Objects;

public class DriveExam extends AbstractTest {
    private String auto;



    public DriveExam(String subject, short duration, short mark, Date date, String auto) {
        super(subject, duration, mark, date);
        this.auto = auto;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DriveExam driveExam = (DriveExam) o;
        return auto.equals(driveExam.auto) && super.equals(driveExam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), auto);
    }

    @Override
    public int compare(AbstractTest o) {
        DriveExam test = (DriveExam) o;
        return this.getSubject().compareTo(test.getSubject());
    }

    @Override
    public int compare2(AbstractTest o){
        if(this.getClass().getName().compareTo(o.getClass().getName()) == 0) {
            return this.getSubject().compareTo(((DriveExam) o).getSubject());
        }
        else return this.getClass().getName().compareTo(o.getClass().getName());
    }

    @Override
    public String toString() {
        return super.toString() + " " + auto ;
    }
}
