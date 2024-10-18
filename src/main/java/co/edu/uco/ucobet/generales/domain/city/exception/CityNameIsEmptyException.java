package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityNameIsEmptyException extends RuleUcoBetException {

	public CityNameIsEmptyException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final CityNameIsEmptyException create() {
		var userMessage = "El nombre de la ciudad no puede estar vacio...";
		return new CityNameIsEmptyException(userMessage);
	}

}
