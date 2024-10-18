package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityNameIsNullException extends RuleUcoBetException{

	public CityNameIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	private static final long serialVersionUID = 1L;
	
	public static final CityNameIsNullException create() {
		var userMessage = "El nombre de la ciudad no puede ser nulo...";
		return new CityNameIsNullException(userMessage);
	}

}
