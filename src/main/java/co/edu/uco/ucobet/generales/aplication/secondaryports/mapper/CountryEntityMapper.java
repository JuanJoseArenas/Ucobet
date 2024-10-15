package co.edu.uco.ucobet.generales.aplication.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.CountryEntity;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

@Mapper
public interface CountryEntityMapper {

	CountryEntityMapper INSTANCE = Mappers.getMapper(CountryEntityMapper.class);

	CountryDomain entityToDomain(CountryEntity entity);

	CountryEntity domainToEntity(CountryDomain domain);

	List<CountryEntity> domainToEntityCollection(List<CountryDomain> domainCollection);

	List<CountryDomain> entityToDomainCollection(List<CountryEntity> entityCollection);

}
