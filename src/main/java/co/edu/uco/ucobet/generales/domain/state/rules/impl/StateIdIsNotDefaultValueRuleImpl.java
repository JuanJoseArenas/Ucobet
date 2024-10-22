package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscuting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.exception.StateIdIsDefaultValueException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;

public class StateIdIsNotDefaultValueRuleImpl implements StateDoesExistsRule {
	
	@Override
	public void validate(UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw StateIdIsDefaultValueException.create();
		}
		
	}

}
