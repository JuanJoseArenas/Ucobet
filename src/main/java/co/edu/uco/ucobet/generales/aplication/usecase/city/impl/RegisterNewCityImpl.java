package co.edu.uco.ucobet.generales.aplication.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.aplication.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.aplication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCity;

import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
@Service
public class RegisterNewCityImpl implements RegisterNewCity {

	private CityRepository cityRepository;
	private RegisterNewCityRulesValidator registerNewCityRulesValidator;

	public RegisterNewCityImpl(final CityRepository cityRepository,
			final RegisterNewCityRulesValidator registerNewCityRulesValidator) {
		this.cityRepository = cityRepository;
		this.registerNewCityRulesValidator = registerNewCityRulesValidator;
	}

	@Override
	public void execute(final CityDomain domain) {

		// Rules validation
		registerNewCityRulesValidator.validate(domain);

		// DataMapper -> Domain -> Entity
		final var cityEntity = CityEntity.create()
				.setId(domain.getId())
				.setName(domain.getName())
				.setState(StateEntityMapper.INSTANCE.domainToEntity(domain.getState()));

		cityRepository.save(cityEntity);
	}

}