package abstractTest;

import java.io.*;
import java.util.Date;
import java.util.Objects;

public class Exam extends AbstractTest {
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
        return examiner.equals(exam.examiner) &&
                super.equals(exam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), examiner);
    }

    /*@Override
    public String toString() {
        return super.toString() + " " +
                 examiner;
    }*/

    @Override
    public String toString() {
        return "{\n" +
                "\"subject\": " + "\"" + this.getSubject() + "\",\n" +
                "\"duration\": " + this.getDuration() + ",\n" +
                "\"mark\": " + this.getMark() + ",\n" +
               // "\"date\": " + this.getDate() + ",\n" +
                "\"examiner\": " + "\"" +this.examiner + "\",\n}";
    }

    @Override
    public int compare(AbstractTest o) {
        Exam test = (Exam) o;
        return this.getExaminer().compareTo(test.getExaminer());
    }

    public int compare2(AbstractTest o){
       // Exam test = (Exam) o;
        if(this.getClass().getName().compareTo(o.getClass().getName()) == 0) {
            return this.getSubject().compareTo(((Exam) o).getSubject());
        }
        else return this.getClass().getName().compareTo(o.getClass().getName());
    }

    public void writeToJSON(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   private void writeObject(ObjectOutputStream stream) throws IOException {

        stream.write(this.toString().getBytes("UTF-8"));
        //stream.writeUTF(this.toString());
        /*stream.writeChar('{');
        stream.writeObject("\"subject\": \"");
        stream.writeObject(this.getSubject());
        stream.writeObject("\",\n");
        stream.writeObject("\"duration\": ");
        stream.writeInt(this.getDuration());
        stream.writeObject(",\n");
        stream.writeObject("\"mark\": ");
        stream.writeShort(this.getMark());
        stream.writeObject(",\n");
        stream.writeObject("\"date\": ");
        stream.writeObject(this.getDate());
        stream.writeObject(",\n");
        stream.writeObject("\"examiner\": ");
        stream.writeObject(this.getExaminer());
        stream.writeObject(",\n");
        stream.writeChar('}');*/
    }

    public void readFromJSON(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            readObject(ois);

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {

        System.out.println(stream.readObject());
    }
    private void readObjectNoData() throws ObjectStreamException {

    }

}
