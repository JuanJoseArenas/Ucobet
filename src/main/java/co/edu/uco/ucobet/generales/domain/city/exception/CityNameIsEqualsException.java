package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityNameIsEqualsException extends RuleUcoBetException {

	public CityNameIsEqualsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final CityNameIsEqualsException create() {
		var userMessage = "Este nombre ya esta asociado a una ciudad...";
		return new CityNameIsEqualsException(userMessage);
	}

}
