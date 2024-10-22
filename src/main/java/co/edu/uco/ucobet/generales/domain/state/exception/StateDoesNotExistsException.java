package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class StateDoesNotExistsException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public StateDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final StateDoesNotExistsException create() {
		var userMessage = "El estado no puede er el valor por defecto";
		return new StateDoesNotExistsException(userMessage);
	}

}
