package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscuting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;

public final class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {
	
	@Override
	public void validate(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsNullException.create();
		}
		
	}

}
