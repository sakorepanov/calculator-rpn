package Exceptions;

public class NotSupportedSymbolsException extends Exception {
    public NotSupportedSymbolsException() {
        super();
    }

    public NotSupportedSymbolsException(String message) {
        super(message);
    }

    public NotSupportedSymbolsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedSymbolsException(Throwable cause) {
        super(cause);
    }
}
