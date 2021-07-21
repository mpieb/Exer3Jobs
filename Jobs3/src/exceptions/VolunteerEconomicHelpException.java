package exceptions;

public class VolunteerEconomicHelpException extends Exception{
	
	private static final String ECONOMIC_HELP_ERROR_DESCRIPTION= "Volunteers cannot receive more than 300€ of help";
	
	public VolunteerEconomicHelpException() {
		super(ECONOMIC_HELP_ERROR_DESCRIPTION);
	}

}