package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;
@Service
public class CityIdDoesNotExistsRuleImpl implements CityIdDoesNotExistsRule{
	
	private CityRepository cityRepository;
	
	public CityIdDoesNotExistsRuleImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public void validate(final UUID data) {
		if(cityRepository.existsById(data)) {
			throw CityIdDoesNotExistsException.create();
			
		}
		
	}

}
