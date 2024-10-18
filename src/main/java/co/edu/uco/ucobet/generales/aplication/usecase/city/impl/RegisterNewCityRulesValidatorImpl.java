package co.edu.uco.ucobet.generales.aplication.usecase.city.impl;



import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;


public final class RegisterNewCityRulesValidatorImpl implements RegisterNewCityRulesValidator {
	
	private RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator;
	private RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator;
	private RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator;
	

	public RegisterNewCityRulesValidatorImpl(final RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator,
			final RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator,
			final RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator) {
		super();
		this.registerNewCityIdRulesValidator = registerNewCityIdRulesValidator;
		this.registerNewCityNameRulesValidator = registerNewCityNameRulesValidator;
		this.registerNewCityStateRulesValidator = registerNewCityStateRulesValidator;
	}


	@Override
	public void validate(final CityDomain data) {
		registerNewCityIdRulesValidator.validate(data);
		registerNewCityNameRulesValidator.validate(data);
		registerNewCityStateRulesValidator.validate(data.getState().getId());

	}

}
