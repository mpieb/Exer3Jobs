package exceptions;

public class SueldoMidException extends Exception{
	
	private static final String MID_EXCEPTION = "Salary of mid employees must be between 1800 and 2500€";
	
	public SueldoMidException() {
		super(MID_EXCEPTION);
	}

}
