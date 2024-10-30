package co.edu.uco.ucobet.generales.crosscuting.messageCatalog;

import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.data.Mensaje;

public interface MessageCatalog {
	
	void inicializar();
	
	String obtenerContenidoMensaje(final CodigoMensaje codigo,String ...parametros);
	Mensaje obtenerMensaje(final CodigoMensaje codigo,String ...parametros);

}
