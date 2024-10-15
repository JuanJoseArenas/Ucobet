package co.edu.uco.ucobet.generales.aplication.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;



@Mapper
public interface StateEntityMapper {
	
	StateEntityMapper INSTANCE = Mappers.getMapper(StateEntityMapper.class);
	
	StateDomain entityToDomain(StateEntity entity);
	StateEntity domainToEntity(StateDomain domain);
	
	List<StateEntity> domainToEntityCollection(List<StateDomain> domainCollection);

	List<StateDomain> entityToDomainCollection(List<StateEntity> entityCollection);
	
}
