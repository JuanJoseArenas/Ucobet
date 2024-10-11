package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.domain.city.exception.CityNameIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;

public class CityNameIsNotEmptyRuleImpl implements CityNameIsNotEmptyRule {

	@Override
	public void validate(String data) {
		if(data.isEmpty()) {
			throw CityNameIsEmptyException.create();
		}
		
	}

}
