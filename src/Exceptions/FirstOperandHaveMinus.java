package Exceptions;

public class FirstOperandHaveMinus extends Exception {
    public FirstOperandHaveMinus() {
        super();
    }

    public FirstOperandHaveMinus(String message) {
        super(message);
    }

    public FirstOperandHaveMinus(String message, Throwable cause) {
        super(message, cause);
    }

    public FirstOperandHaveMinus(Throwable cause) {
        super(cause);
    }
}
