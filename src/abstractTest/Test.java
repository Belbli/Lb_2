package abstractTest;

import java.util.Date;
import java.util.Objects;

public class Test extends AbstractTest{
    private int numberOfQuestions;

    public Test() {
        objectsCreatedCount++;
    }

    public Test(String subject, short duration, short mark, Date date, int numberOfQuestions) {
        super(subject, duration, mark, date);
        this.numberOfQuestions = numberOfQuestions;
    }

    public Test(Test test){
        super(test);
        this.numberOfQuestions = test.numberOfQuestions;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Test test = (Test) o;
        return numberOfQuestions == test.numberOfQuestions
                && super.equals(test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfQuestions);
    }

    @Override
    public String toString() {
        return super.toString() + " " + numberOfQuestions;
    }

    @Override
    public int compare(AbstractTest o) {
        Test test = (Test) o;
        return this.getNumberOfQuestions() - test.getNumberOfQuestions();
    }

    public int compare2(AbstractTest o){
//        Test test = (Test) o;
        if(this.getClass().getName().compareTo(o.getClass().getName()) == 0) {
            return this.getNumberOfQuestions() - ((Test) o).getNumberOfQuestions();
        }
        else return this.getClass().getName().compareTo(o.getClass().getName());
    }
}
