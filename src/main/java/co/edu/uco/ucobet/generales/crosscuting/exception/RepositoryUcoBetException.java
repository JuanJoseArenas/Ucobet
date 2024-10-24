package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class RepositoryUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public RepositoryUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.CROSSCUTING);
	}
	
	public static final RepositoryUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new RepositoryUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final RepositoryUcoBetException create(final String userMessage) {
		return new RepositoryUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final RepositoryUcoBetException create(final String userMessage, final String technicalMessage) {
		return new RepositoryUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
