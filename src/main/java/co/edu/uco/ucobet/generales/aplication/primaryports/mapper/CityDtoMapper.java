package co.edu.uco.ucobet.generales.aplication.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.CityDTO;

import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Mapper

public interface CityDtoMapper {

	CityDtoMapper INSTANCE = Mappers.getMapper(CityDtoMapper.class);

	CityDomain dtoToDomain(CityDTO dto);

	CityDTO domainToDto(CityDomain domain);

	List<CityDTO> domainToDtoCollection(List<CityDomain> domainCollection);

	List<CityDomain> dtoToDomainCollection(List<CityDTO> entityCollection);

}
