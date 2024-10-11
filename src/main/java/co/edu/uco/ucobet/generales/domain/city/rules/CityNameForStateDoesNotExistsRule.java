package co.edu.uco.ucobet.generales.domain.city.rules;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.DomainRule;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service

public interface CityNameForStateDoesNotExistsRule extends DomainRule<CityDomain> {

}
