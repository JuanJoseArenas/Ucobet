package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public final class CityIdDoesNotExistsException extends RuleUcoBetException {

	public CityIdDoesNotExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final CityIdDoesNotExistsException create() {
		var userMessage = "No existe la ciudad con el id indicado...";
		return new CityIdDoesNotExistsException(userMessage);
	}

}
