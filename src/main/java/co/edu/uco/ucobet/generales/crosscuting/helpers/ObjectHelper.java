package co.edu.uco.ucobet.generales.crosscuting.helpers;

public class ObjectHelper {

	private static final ObjectHelper INSTANCE = new ObjectHelper();
	
	private ObjectHelper() {

	}
	public static final ObjectHelper getObjectHelper() {
		return INSTANCE;
	}

	public static <O> boolean isNull(final O object) {
		return object == null;
	}

	public static <O> O getDefault(final O object, final O defaultObject) {
		return isNull(object) ? defaultObject : object;
	}

}
