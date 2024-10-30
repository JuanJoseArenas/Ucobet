package co.edu.uco.ucobet.generales.aplication.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public final class RegisterNewCityRulesValidatorImpl implements RegisterNewCityRulesValidator {
	
	private RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator;
	private RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator;
	private RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator;
	

	public RegisterNewCityRulesValidatorImpl(final RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator,
			final RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator,
			final RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator) {
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
