package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;

public class EntityUcoBetException extends UcobetException {

	private static final long serialVersionUID = 1L;

	public EntityUcoBetException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}
	
	public static final EntityUcoBetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new EntityUcoBetException(userMessage, technicalMessage, rootException);
	}
	
	public static final EntityUcoBetException create(final String userMessage) {
		return new EntityUcoBetException(userMessage, userMessage, new Exception());
	}
	
	public static final EntityUcoBetException create(final String userMessage, final String technicalMessage) {
		return new EntityUcoBetException(userMessage, technicalMessage, new Exception());
	}

}
