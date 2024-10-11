package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityNameFormatIsNotValidException extends RuleUcoBetException{

	public CityNameFormatIsNotValidException(String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	private static final long serialVersionUID = 1L;
	
	public static final CityNameFormatIsNotValidException create() {
		var userMessage = "/////...";
		return new CityNameFormatIsNotValidException(userMessage);
	}


}
