package exceptions;

public class DuplicatePlayerException extends Exception{
    private String message;

    public DuplicatePlayerException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
