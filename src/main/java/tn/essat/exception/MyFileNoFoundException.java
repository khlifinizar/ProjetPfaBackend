package tn.essat.exception;

public class MyFileNoFoundException extends RuntimeException {
	public MyFileNoFoundException(String message) {
		super(message);
	}
	public MyFileNoFoundException (String message,Throwable cause) {
		super(message,cause);
	}

}
