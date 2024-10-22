package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class StateIdIsDefaultValueException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public StateIdIsDefaultValueException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final StateIdIsDefaultValueException create() {
		var userMessage = "El estado no existe";
		return new StateIdIsDefaultValueException(userMessage);
	}

}
