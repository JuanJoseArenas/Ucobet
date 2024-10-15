package co.edu.uco.ucobet.generales.aplication.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper

public interface StateDtoMapper {

	StateDtoMapper INSTANCE = Mappers.getMapper(StateDtoMapper.class);

	StateDomain dtoToDomain(StateDTO dto);

	StateDTO domainToDto(StateDomain domain);

	List<StateDTO> domainToDtoCollection(List<StateDomain> domainCollection);

	List<StateDomain> dtoToDomainCollection(List<StateDTO> entityCollection);

}
