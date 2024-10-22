package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscuting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.exception.StateIdIsNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;

public class StateIdIsNotNullRuleImpl implements StateDoesExistsRule {
	
	@Override
	public void validate(UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw StateIdIsNullException.create();
		}
		
	}

}
