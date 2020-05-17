package exeption;

public class TestTypeExeption extends RuntimeException {

    public TestTypeExeption() {}

    public TestTypeExeption(String msg) {
        super(msg);
    }

}
