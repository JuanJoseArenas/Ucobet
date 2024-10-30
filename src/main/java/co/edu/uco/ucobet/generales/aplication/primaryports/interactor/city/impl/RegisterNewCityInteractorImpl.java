package co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.aplication.primaryports.mapper.RegisterNewCityMapper;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCity;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private RegisterNewCity registerNewCity;

	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCity) {
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(final RegisterNewCityDTO data) {

		// DataMapper -> DTO -> Domain
		var cityDomain = RegisterNewCityMapper.INSTANCE.toDomain(data);
		registerNewCity.execute(cityDomain);

	}

}
