package co.edu.uco.ucobet.generales.crosscuting.helpers;

public class TextHelper {

	public static final String EMPTY = "";
	public static final String UNDERLINE = "_";

	private TextHelper() {

	}

	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}

	public static String getDefault(final String string, final String defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}

	public static String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}

	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}
	
	public static final String concatenate(final String...strings) {
		final var sb = new StringBuilder(EMPTY);
		
		if(!ObjectHelper.getObjectHelper().isNull(strings)) {
			for (final var string : strings) {
				sb.append(applyTrim(string));
			}
		}
		
		return sb.toString();
	}
	
	public static String applyTrim(final String string) {
		return getDefault(string).trim();
	}
	public static String reemplazarParametro(String mensaje, String... parametros) {
		String mensajeReemplazado = mensaje;
		for(int i = 0; i< parametros.length; i++) {
			String marcador = "${" + (i+1) + "}";
			mensajeReemplazado = mensajeReemplazado.replace(marcador, parametros[i]);
		}
		return mensajeReemplazado;	
	}

}
