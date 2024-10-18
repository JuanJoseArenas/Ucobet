package co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.impl;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

	private RegisterNewCity registerNewCity;
	
	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCity) {
		super();
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(final RegisterNewCityDTO data) {
		//DataMapper -> DTO -> Domain
		final var cityDomain = new CityDomain(null, null, null);
		
		registerNewCity.execute(cityDomain);
	}

}
