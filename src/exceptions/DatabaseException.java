package exceptions;

public class DatabaseException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public DatabaseException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
