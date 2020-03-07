import java.util.Date;
import java.util.Objects;

abstract public class Trial {
    public static int objectsCreatedCount = 0;
    private String subject;
    private short duration;
    private short mark;
    private Date date;

    public Trial(){}

    public Trial(String subject, short duration, short mark, Date date) {
        this.subject = subject;
        this.duration = duration;
        this.mark = mark;
        this.date = date;
        objectsCreatedCount++;
    }

    public Trial(Trial trial){
        this.subject = trial.subject;
        this.duration = trial.duration;
        this.mark = trial.mark;
        this.date = trial.date;
        objectsCreatedCount++;
    }

    public static int getObjectsCreatedCount() {
        return objectsCreatedCount;
    }

    public static void setObjectsCreatedCount(int objectsCreatedCount) {
        Trial.objectsCreatedCount = objectsCreatedCount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public short getMark() {
        return mark;
    }

    public void setMark(short mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Trial{" +
                "subject='" + subject + '\'' +
                ", duration=" + duration +
                ", mark=" + mark +
                '}' + "date=" + date + ' ';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return duration == trial.duration &&
                mark == trial.mark &&
                Objects.equals(subject, trial.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, duration, mark);
    }
}
