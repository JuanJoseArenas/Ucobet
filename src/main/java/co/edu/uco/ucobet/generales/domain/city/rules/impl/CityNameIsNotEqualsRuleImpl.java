package co.edu.uco.ucobet.generales.domain.city.rules.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameIsEqualsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEqualsRule;

@Service
public class CityNameIsNotEqualsRuleImpl implements CityNameIsNotEqualsRule {
	
	private CityRepository cityRepository;
	
	public CityNameIsNotEqualsRuleImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public void validate(String data) {
		if(cityRepository.existsByNameIgnoreCase(data)) {
			throw CityNameIsEqualsException.create();
		}
		
	}

}
