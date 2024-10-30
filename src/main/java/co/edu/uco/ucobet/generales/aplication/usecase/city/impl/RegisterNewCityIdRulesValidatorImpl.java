package co.edu.uco.ucobet.generales.aplication.usecase.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;

@Service
public final class RegisterNewCityIdRulesValidatorImpl implements RegisterNewCityIdRulesValidator {

	private CityIdDoesNotExistsRule cityIdDoesNotExistRule;

	public RegisterNewCityIdRulesValidatorImpl(final CityIdDoesNotExistsRule cityIdDoesNotExistRule) {
		super();
		this.cityIdDoesNotExistRule = cityIdDoesNotExistRule;
	}


	@Override
	public void validate(CityDomain data) {
		data.generateId();
		try {
			cityIdDoesNotExistRule.validate(data.getId());
		} catch (final CityIdDoesExistsException exception) {
			validate(data);
		}
	}
	
}