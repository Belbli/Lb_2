package AbstractTest;

import java.util.Date;
import java.util.Objects;

public abstract class AbstractTest implements AbstractTestComparable{
    public static int objectsCreatedCount = 0;
    private String subject;
    private short duration;
    private short mark;
    private Date date;

    public AbstractTest(){}

    public AbstractTest(String subject, short duration, short mark, Date date) {
        this.subject = subject;
        this.duration = duration;
        this.mark = mark;
        this.date = date;
        objectsCreatedCount++;
    }

    public AbstractTest(AbstractTest trial){
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
        AbstractTest.objectsCreatedCount = objectsCreatedCount;
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
        return "AbstractTest{" +
                "subject='" + subject + '\'' +
                ", duration=" + duration +
                ", mark=" + mark +
                '}' + "date=" + date + ' ';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTest test = (AbstractTest) o;
        return duration == test.duration &&
                mark == test.mark &&
                Objects.equals(subject, test.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, duration, mark);
    }
}
