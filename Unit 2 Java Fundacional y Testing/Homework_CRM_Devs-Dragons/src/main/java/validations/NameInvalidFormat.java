package validations;

public class NameInvalidFormat extends Exception {
    public NameInvalidFormat() {
    }

    public NameInvalidFormat(String message) {
        super(message);
    }
}
