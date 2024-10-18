package co.edu.uco.ucobet.generales.domain.city.exception;



import co.edu.uco.ucobet.generales.crosscuting.exception.RuleUcoBetException;

public class CityNameLenghtIsNotValidException extends RuleUcoBetException{

	public CityNameLenghtIsNotValidException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	
	public static final CityNameLenghtIsNotValidException create() {
		var userMessage = "El tamaño del nombre de la ciudad no es correcto...";
		return new CityNameLenghtIsNotValidException(userMessage);
	}


}
