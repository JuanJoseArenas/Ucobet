package co.edu.uco.ucobet.generales.aplication.secondaryports.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.StateEntity;


@Repository
public interface StateRepository extends JpaRepository<StateEntity, UUID> {

}
