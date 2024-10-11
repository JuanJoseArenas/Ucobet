package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class GeneralUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public GeneralUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.GENERAL);
	}
	
	public static final GeneralUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new GeneralUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final GeneralUcoBetException create(final String userMessage) {
		return new GeneralUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final GeneralUcoBetException create(final String userMessage, final String technicalMessage) {
		return new GeneralUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
