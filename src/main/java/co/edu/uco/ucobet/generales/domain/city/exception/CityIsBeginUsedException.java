package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityIsBeginUsedException extends RuleUcoBetException
{

	public CityIsBeginUsedException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final CityIsBeginUsedException create() {
		var userMessage = "/////...";
		return new CityIsBeginUsedException(userMessage);
	}

}
