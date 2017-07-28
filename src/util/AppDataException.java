package util;

public class AppDataException {
	private Throwable innerException;
	private String message;
	
	public Throwable getInnerException() {
		return innerException;
	}

	public void setInnerException(Throwable innerException) {
		this.innerException = innerException;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AppDataException(Throwable e, String message){
		this.innerException = e;
		this.setMessage(message);
	}

}
