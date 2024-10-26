package co.edu.uco.ucobet.generales.aplication.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.RegisterNewCityEntity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;


@Mapper
public interface RegisterNewCitytMapper {

	RegisterNewCitytMapper INSTANCE = Mappers.getMapper(RegisterNewCitytMapper.class);

	CityDomain entityToDomain(RegisterNewCityEntity entity);

	RegisterNewCityEntity domainToEntity(CityDomain domain);

	List<RegisterNewCityEntity> domainToEntityCollection(List<CityDomain> domainCollection);

	List<CityDomain> entityToDomainCollection(List<RegisterNewCityEntity> entityCollection);

}
