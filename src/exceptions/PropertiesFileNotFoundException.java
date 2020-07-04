package exceptions;

public class PropertiesFileNotFoundException extends Exception{
    private String message;

    public PropertiesFileNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
