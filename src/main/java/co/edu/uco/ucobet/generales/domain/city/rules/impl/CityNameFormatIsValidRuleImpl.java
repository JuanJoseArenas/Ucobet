package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscuting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data)) {
			throw CityNameFormatIsNotValidException.create();
		}
	}
}
