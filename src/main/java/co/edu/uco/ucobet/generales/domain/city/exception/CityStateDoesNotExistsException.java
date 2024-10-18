package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityStateDoesNotExistsException extends RuleUcoBetException{

	public CityStateDoesNotExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final CityStateDoesNotExistsException create() {
		var userMessage = "El estado asociado a la ciudad no existe...";
		return new CityStateDoesNotExistsException(userMessage);
	}

}
