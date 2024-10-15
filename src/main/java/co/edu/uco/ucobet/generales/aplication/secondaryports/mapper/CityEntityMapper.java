package co.edu.uco.ucobet.generales.aplication.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Mapper
public interface CityEntityMapper {

	CityEntityMapper INSTANCE = Mappers.getMapper(CityEntityMapper.class);

	CityDomain entityToDomain(CityEntity entity);

	CityEntity domainToEntity(CityDomain domain);

	List<CityEntity> domainToEntityCollection(List<CityDomain> domainCollection);

	List<CityDomain> entityToDomainCollection(List<CityEntity> entityCollection);

}
