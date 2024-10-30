package co.edu.uco.ucobet.generales.aplication.usecase.city.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.aplication.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.aplication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.aplication.usecase.city.RetrieveCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public class RetrieveCityImpl implements RetrieveCity{
	
	private CityRepository cityRepository;
	
	public RetrieveCityImpl(final CityRepository cityRepository ) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<CityDomain> execute(CityDomain domain) {
		var cityEntity = CityEntityMapper.INSTANCE.domainToEntity(domain);
		var resultadosEntity = cityRepository.findByFilter(cityEntity);
		return CityEntityMapper.INSTANCE.entityToDomainCollection(resultadosEntity);
	}

}
