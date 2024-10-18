package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityNameForStateDoesExistsException extends RuleUcoBetException {

	public CityNameForStateDoesExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;

	public static final CityNameForStateDoesExistsException create() {
		var userMessage = "El nombre de la ciudad para este departamento ya existe...";
		return new CityNameForStateDoesExistsException(userMessage);
	}
}
