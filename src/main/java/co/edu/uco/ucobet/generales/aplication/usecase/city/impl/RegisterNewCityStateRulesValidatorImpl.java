package co.edu.uco.ucobet.generales.aplication.usecase.city.impl;


import java.util.UUID;

import co.edu.uco.ucobet.generales.aplication.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;


public final class RegisterNewCityStateRulesValidatorImpl implements RegisterNewCityStateRulesValidator {

	private StateDoesExistsRule stateDoesExistsRule;
	private StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule;
	private StateIdIsNotNullRule stateIdIsNotNullRule;
	
	

	public RegisterNewCityStateRulesValidatorImpl(final StateDoesExistsRule stateDoesExistsRule,
			 final StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule, final StateIdIsNotNullRule stateIdIsNotNullRule) {
		super();
		this.stateDoesExistsRule = stateDoesExistsRule;
		this.stateIdIsNotDefaultValueRule = stateIdIsNotDefaultValueRule;
		this.stateIdIsNotNullRule = stateIdIsNotNullRule;
	}
	@Override
	public void validate(final UUID stateid) {
		validateState(stateid);
				
	}
	
	public void validateState(final UUID stateid) {
		stateDoesExistsRule.validate(stateid);
		stateIdIsNotDefaultValueRule.validate(stateid);
		stateIdIsNotNullRule.validate(stateid);
		
		
	}


}


