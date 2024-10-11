package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class RuleUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public RuleUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.RULE);
	}
	
	public static final RuleUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new RuleUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final RuleUcoBetException create(final String userMessage) {
		return new RuleUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final RuleUcoBetException create(final String userMessage, final String technicalMessage) {
		return new RuleUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
