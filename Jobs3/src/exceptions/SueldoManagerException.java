package exceptions;

public class SueldoManagerException extends Exception{
	
	private static final String MANAGER_EXCEPTION = "Salary of a manager must be between 3000 and 5000€";
	
	public SueldoManagerException() {
		super(MANAGER_EXCEPTION);
	}

}


