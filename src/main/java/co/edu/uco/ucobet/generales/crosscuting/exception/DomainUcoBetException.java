package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class DomainUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public DomainUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.APPLICATION);
	}
	
	public static final DomainUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new DomainUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final DomainUcoBetException create(final String userMessage) {
		return new DomainUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final DomainUcoBetException create(final String userMessage, final String technicalMessage) {
		return new DomainUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
