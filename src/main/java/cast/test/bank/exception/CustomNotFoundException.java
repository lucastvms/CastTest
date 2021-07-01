package cast.test.bank.exception;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String s) {
        super(s);
    }
}
