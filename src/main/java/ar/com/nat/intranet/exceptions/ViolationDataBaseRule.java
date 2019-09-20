package ar.com.nat.intranet.exceptions;

@SuppressWarnings("serial")
public class ViolationDataBaseRule extends Exception{
	
	public ViolationDataBaseRule(String message) {
		super(message);
	}
	
	public ViolationDataBaseRule(Throwable cause) {
		super(cause);
	}

	public ViolationDataBaseRule(String message,Throwable cause) {
		super(message,cause);
	}
}
