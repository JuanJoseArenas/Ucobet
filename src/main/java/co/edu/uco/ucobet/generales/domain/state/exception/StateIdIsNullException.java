package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class StateIdIsNullException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public StateIdIsNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final StateIdIsNullException create() {
		var userMessage = "El Id del estado no puede ser nulo";
		return new StateIdIsNullException(userMessage);
	}

}
