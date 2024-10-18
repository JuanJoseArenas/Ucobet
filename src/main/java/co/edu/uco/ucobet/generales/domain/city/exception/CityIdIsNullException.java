package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityIdIsNullException extends RuleUcoBetException {

	public CityIdIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	private static final long serialVersionUID = 1L;

	public static final CityIdIsNullException create() {
		var userMessage = "El Id  de la ciudad no puede ser Nulo...";
		return new CityIdIsNullException(userMessage);
	}
}
