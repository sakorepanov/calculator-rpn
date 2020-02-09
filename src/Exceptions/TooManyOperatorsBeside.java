package Exceptions;

public class TooManyOperatorsBeside extends Exception {
    public TooManyOperatorsBeside() {
        super();
    }

    public TooManyOperatorsBeside(String message) {
        super(message);
    }

    public TooManyOperatorsBeside(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyOperatorsBeside(Throwable cause) {
        super(cause);
    }
}
