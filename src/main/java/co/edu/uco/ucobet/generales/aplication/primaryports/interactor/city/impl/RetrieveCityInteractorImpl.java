package co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.CityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.RetrieveCityInteractor;
import co.edu.uco.ucobet.generales.aplication.primaryports.mapper.CityDtoMapper;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RetrieveCity;

@Service
@Transactional
public class RetrieveCityInteractorImpl implements RetrieveCityInteractor {
	
	public RetrieveCity retrieveCity;
	
	public RetrieveCityInteractorImpl (RetrieveCity retrieveCity) {
		this.retrieveCity = retrieveCity;
	}

	@Override
	public List<CityDTO> execute(CityDTO data) {
		var cityDomain = CityDtoMapper.INSTANCE.dtoToDomain(data);
		var resultados = retrieveCity.execute(cityDomain);
		return CityDtoMapper.INSTANCE.domainToDtoCollection(resultados);
	}

}

