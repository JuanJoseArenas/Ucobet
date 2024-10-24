package co.edu.uco.ucobet.generales.crosscuting.exception.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.crosscuting.exception.CrosscutingUcoBetException;
import co.edu.uco.ucobet.generales.crosscuting.exception.messagecatalog.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscuting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscuting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.crosscuting.exception.messagecatalog.data.Mensaje;
import co.edu.uco.ucobet.generales.crosscuting.helpers.ObjectHelper;

public final class MessageCatalogExternalService  implements MessageCatalog{
	
	private final Map<String, Mensaje> mensajes = new HashMap<> ();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00007.getIdentificador(),
				new Mensaje(CodigoMensaje.M00007, "La transaccion se ha completado de forma satisfactoria"));
		
	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {
		
		if(ObjectHelper.getObjectHelper().isNull(codigo)){
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico =  MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscutingUcoBetException(mensajeTecnico, mensajeUsuario);
		}
		if(codigo.isBase()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,codigo.getIdentificador());
			throw new CrosscutingUcoBetException(mensajeTecnico, mensajeUsuario);
		}
		if(!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,codigo.getIdentificador());
			throw new CrosscutingUcoBetException(mensajeTecnico, mensajeUsuario);
		}
		return mensajes.get(codigo.getIdentificador());
	}

}
