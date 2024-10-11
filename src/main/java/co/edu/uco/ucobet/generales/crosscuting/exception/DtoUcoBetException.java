package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class DtoUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public DtoUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.DTO);
	}
	
	public static final DtoUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new DtoUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final DtoUcoBetException create(final String userMessage) {
		return new DtoUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final DtoUcoBetException create(final String userMessage, final String technicalMessage) {
		return new DtoUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
