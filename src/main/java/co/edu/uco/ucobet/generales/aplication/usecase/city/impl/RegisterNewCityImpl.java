package co.edu.uco.ucobet.generales.aplication.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.aplication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCity;

import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

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
		final var cityEntity = CityEntity.create(null);

		cityRepository.save(cityEntity);

		// Notificar al administrador sobre la creación de la nueva ciudad
		// : ¿Cómo? Notification Building Block

		// Tenga en cuenta que:
		// 1. El correo del administrador está en un lugar parametrizado (Parameters
		// Building Block)
		// 2. El asunto del correo está en un lugar parametrizado (Parameters Building
		// Block)
		// 3. El cuerpo del correo está en un lugar parametrizado (Parameters Building
		// Block)
	}

}