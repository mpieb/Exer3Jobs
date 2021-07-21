package exceptions;

public class SueldoBossException extends Exception{
	
	private static final String BOSS_EXCEPTION = "Salary of a boss must be above 8000€";
	
	public SueldoBossException() {
		super(BOSS_EXCEPTION);
	}

}


