package co.edu.uco.ucobet.generales.aplication.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper

public interface StateDtoMapper {

	StateDtoMapper INSTANCE = Mappers.getMapper(StateDtoMapper.class);

	StateDomain dtoToDomain(RetrieveStateDTO dto);

	RetrieveStateDTO domainToDto(StateDomain domain);

	List<RetrieveStateDTO> domainToDtoCollection(List<StateDomain> domainCollection);

	List<StateDomain> dtoToDomainCollection(List<RetrieveStateDTO> entityCollection);

}
