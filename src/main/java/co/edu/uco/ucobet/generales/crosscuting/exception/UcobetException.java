package co.edu.uco.ucobet.generales.crosscuting.exception;

import co.edu.uco.ucobet.generales.crosscuting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscuting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.TextHelper;

public class UcobetException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String userMessage;
	private Layer layer;
	
	
	public UcobetException(final String userMessage, final String technicalMessage, final Exception rootException, final Layer layer) {
		super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)), ObjectHelper.getDefault(rootException, new Exception()));
		setUserMessage(userMessage);
		setLayer(layer);
	}

	public UcobetException(final String userMessage, final String technicalMessage) {
		super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)));
	}

	private void setLayer(Layer layer) {
		this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
	}


	public Layer getLayer() {
		return layer;
	}


	public String getUserMessage() {
		return userMessage;
	}


	private void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.applyTrim(userMessage);
	}
	
	

}
