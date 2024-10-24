package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class CrosscutingUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public CrosscutingUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.CROSSCUTING);
	}
	public CrosscutingUcoBetException(final String userMessage, final String technicalMessage){
		super(userMessage, technicalMessage);
	}
	
	public static final CrosscutingUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new CrosscutingUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final CrosscutingUcoBetException create(final String userMessage) {
		return new CrosscutingUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final CrosscutingUcoBetException create(final String userMessage, final String technicalMessage) {
		return new CrosscutingUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
