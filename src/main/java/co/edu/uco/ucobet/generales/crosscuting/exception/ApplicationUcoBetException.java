package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class ApplicationUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public ApplicationUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.DOMAIN);
	}
	
	public static final ApplicationUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new ApplicationUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final ApplicationUcoBetException create(final String userMessage) {
		return new ApplicationUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final ApplicationUcoBetException create(final String userMessage, final String technicalMessage) {
		return new ApplicationUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
