package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class UseCaseUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public UseCaseUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.USECASE);
	}
	
	public static final UseCaseUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new UseCaseUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final UseCaseUcoBetException create(final String userMessage) {
		return new UseCaseUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final UseCaseUcoBetException create(final String userMessage, final String technicalMessage) {
		return new UseCaseUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
