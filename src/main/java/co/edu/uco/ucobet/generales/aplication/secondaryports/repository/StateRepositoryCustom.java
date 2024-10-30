package co.edu.uco.ucobet.generales.aplication.secondaryports.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.StateEntity;

@Repository
public interface StateRepositoryCustom {
	List<StateEntity> findByfilter(StateEntity filter);

}
