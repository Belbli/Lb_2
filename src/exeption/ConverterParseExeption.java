package exeption;

public class ConverterParseExeption extends RuntimeException {
    public ConverterParseExeption() {
    }

    public ConverterParseExeption(String message) {
        super(message);
    }
}
