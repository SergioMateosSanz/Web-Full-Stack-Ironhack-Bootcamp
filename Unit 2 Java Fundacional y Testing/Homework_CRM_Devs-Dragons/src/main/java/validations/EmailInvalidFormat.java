package validations;

public class EmailInvalidFormat extends Exception {

    public EmailInvalidFormat() {
    }

    public EmailInvalidFormat(String message) {
        super(message);
    }

}