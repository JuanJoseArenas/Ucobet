package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIsBeginUsedException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeginUsedRule;
@Service
public class CityIsNotBeginUsedRuleImpl implements CityIsNotBeginUsedRule {
	
	private CityRepository cityRepository;


	public CityIsNotBeginUsedRuleImpl(final CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}


	@Override
	public void validate(UUID data) {
		if(cityRepository.isCityBeingUsed(data)) {
			throw CityIsBeginUsedException.create();
		}
	}
}
