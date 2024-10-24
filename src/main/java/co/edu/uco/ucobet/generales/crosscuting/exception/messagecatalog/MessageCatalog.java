package co.edu.uco.ucobet.generales.crosscuting.exception.messagecatalog;

import co.edu.uco.ucobet.generales.crosscuting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.crosscuting.exception.messagecatalog.data.Mensaje;

public interface MessageCatalog {

	
	void inicializar();
	
	String obtenerContenidoMensaje(final CodigoMensaje codigo, String...parametros);
	Mensaje obtenerMensaje(final CodigoMensaje codigo, String...parametros);

}

