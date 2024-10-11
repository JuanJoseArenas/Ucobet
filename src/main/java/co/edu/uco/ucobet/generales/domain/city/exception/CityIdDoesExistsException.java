package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public final class CityIdDoesExistsException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public CityIdDoesExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());

	}
	
	public static final CityIdDoesExistsException create() {
		var userMessage = "Ya existe una ciudad con ese id...";
		return new CityIdDoesExistsException(userMessage);
	}

}
