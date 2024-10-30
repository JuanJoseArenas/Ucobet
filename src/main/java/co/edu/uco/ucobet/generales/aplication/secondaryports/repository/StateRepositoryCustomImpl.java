package co.edu.uco.ucobet.generales.aplication.secondaryports.repository;

import java.util.ArrayList;
import java.util.List;
import co.edu.uco.ucobet.generales.aplication.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.crosscuting.exception.RepositoryUcoBetException;
import co.edu.uco.ucobet.generales.crosscuting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

public class StateRepositoryCustomImpl implements StateRepositoryCustom{
	
	private EntityManager entityManager;

	public StateRepositoryCustomImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<StateEntity> findByfilter(StateEntity filter) {
	    try {
	        var criteriaBuilder = entityManager.getCriteriaBuilder();
	        var query = criteriaBuilder.createQuery(StateEntity.class);
	        var result = query.from(StateEntity.class);

	        var predicates = new ArrayList<Predicate>();

	        if (!ObjectHelper.isNull(filter)) {
	            if (!UUIDHelper.isDefault(filter.getId())) {
	                predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
	            }

	            if (!TextHelper.isEmpty(filter.getName())) {
	                predicates.add(criteriaBuilder.equal(result.get("name"), filter.getName()));
	            }

	            if (!UUIDHelper.isDefault(filter.getCountry().getId())) {
	                predicates.add(criteriaBuilder.equal(result.get("country"), filter.getCountry().getId()));
	            }
	        }

	        query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
	        return entityManager.createQuery(query).getResultList();

	    } catch (final Exception exception) {
	        throw RepositoryUcoBetException.create(null, null, exception);
	    }
	}

}
