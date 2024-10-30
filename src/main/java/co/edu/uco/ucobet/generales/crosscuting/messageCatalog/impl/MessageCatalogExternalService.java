package co.edu.uco.ucobet.generales.crosscuting.messageCatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.crosscuting.exception.CrosscutingUcoBetException;
import co.edu.uco.ucobet.generales.crosscuting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.data.Mensaje;

public class MessageCatalogExternalService implements MessageCatalog {

	private final Map<String,Mensaje> mensajes = new HashMap<>();

	@Override
	public void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00007.getIdentificador(),
				new Mensaje(CodigoMensaje.M00007,"la transaccion se a completado de forma satisfactoria..."));
		
	}

	@Override
	public String obtenerContenidoMensaje(CodigoMensaje codigo, String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public Mensaje obtenerMensaje(CodigoMensaje codigo, String... parametros) {
		if (ObjectHelper.isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscutingUcoBetException(mensajeTecnico,mensajeUsuario);
			
		}
		
		if (codigo.isBase()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,codigo.getIdentificador());
			throw new CrosscutingUcoBetException(mensajeTecnico,mensajeUsuario);
		}
		
		if (!mensajes.containsKey(codigo.getIdentificador()) ){
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006,codigo.getIdentificador());
			throw new CrosscutingUcoBetException(mensajeTecnico,mensajeUsuario);
		}
		return mensajes.get(codigo.getIdentificador());
	}
	
	
	
}