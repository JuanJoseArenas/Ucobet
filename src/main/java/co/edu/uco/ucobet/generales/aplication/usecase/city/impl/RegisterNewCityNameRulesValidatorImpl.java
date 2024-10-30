package co.edu.uco.ucobet.generales.aplication.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEqualsRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghtIsValidRule;
@Service
public final class RegisterNewCityNameRulesValidatorImpl implements RegisterNewCityNameRulesValidator {

	private CityNameLenghtIsValidRule cityNameLengthIsValidRule;
	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
	private CityNameIsNotEmptyRule cityNameIsNotEmptyRule;
	private CityNameIsNotNullRule cityNameIsNotNullRule;
	private CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistRule;
	private CityNameIsNotEqualsRule cityNameIsNotEqualsRule;

	public RegisterNewCityNameRulesValidatorImpl(final CityNameLenghtIsValidRule cityNameLengthIsValidRule,
			final CityNameFormatIsValidRule cityNameFormatIsValidRule,
			final CityNameIsNotEmptyRule cityNameIsNotEmptyRule, final CityNameIsNotNullRule cityNameIsNotNullRule,
			final CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistRule, final CityNameIsNotEqualsRule cityNameIsNotEqualsRule ) {
		super();
		this.cityNameLengthIsValidRule = cityNameLengthIsValidRule;
		this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
		this.cityNameIsNotEmptyRule = cityNameIsNotEmptyRule;
		this.cityNameIsNotNullRule = cityNameIsNotNullRule;
		this.cityNameForStateDoesNotExistRule = cityNameForStateDoesNotExistRule;
		this.cityNameIsNotEqualsRule =  cityNameIsNotEqualsRule ;
	}

	@Override
	public void validate(CityDomain data) {
		cityNameIsNotNullRule.validate(data.getName());
		cityNameIsNotEmptyRule.validate(data.getName());
		cityNameLengthIsValidRule.validate(data.getName());
		cityNameFormatIsValidRule.validate(data.getName());
		cityNameForStateDoesNotExistRule.validate(data);
		cityNameIsNotEqualsRule.validate(data.getName());
	}

}
