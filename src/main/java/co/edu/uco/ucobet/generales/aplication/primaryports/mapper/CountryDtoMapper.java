package co.edu.uco.ucobet.generales.aplication.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.ucobet.generales.aplication.primaryports.dto.CountryDTO;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

@Mapper

public interface CountryDtoMapper {

	CountryDtoMapper INSTANCE = Mappers.getMapper(CountryDtoMapper.class);

	CountryDomain dtoToDomain(CountryDTO dto);

	CountryDTO domainToDto(CountryDomain domain);

	List<CountryDTO> domainToDtoCollection(List<CountryDomain> domainCollection);

	List<CountryDomain> dtoToDomainCollection(List<CountryDTO> entityCollection);

}
