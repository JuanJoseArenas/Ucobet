package co.edu.uco.ucobet.generales.crosscuting.messageCatalog;

import co.edu.uco.ucobet.generales.crosscuting.exception.CrosscutingUcoBetException;
import co.edu.uco.ucobet.generales.crosscuting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.data.Mensaje;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.impl.MessageCatalogBase;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.impl.MessageCatalogExternalService;

public class MessageCatalogStrategy {

	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();

	static {
		inicializar();
	}

	private MessageCatalogStrategy() {
		super();
	}

	public static void inicializar() {
		base.inicializar();
		externalService.inicializar();

	}

	private static final MessageCatalog getStrategy(final boolean isBase) {
		return isBase ? base : externalService;
	}

	private static final Mensaje getMensaje(final CodigoMensaje codigo, final String... parametros) {
		if (ObjectHelper.isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscutingUcoBetException(mensajeTecnico, mensajeUsuario);
		}

		return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);

	}

	public static final String getContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return getMensaje(codigo, parametros).getContenido();

	}
}