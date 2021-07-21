package exceptions;

public class SueldoSeniorException extends Exception{
	
	private static final String SENIOR_EXCEPTION = "Salary of junior employees must be between 2700 and 4000€";
	
	public SueldoSeniorException() {
		super(SENIOR_EXCEPTION);
	}

}


