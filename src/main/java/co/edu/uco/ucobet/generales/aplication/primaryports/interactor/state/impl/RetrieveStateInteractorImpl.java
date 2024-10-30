package co.edu.uco.ucobet.generales.aplication.primaryports.interactor.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.aplication.primaryports.mapper.StateDtoMapper;
import co.edu.uco.ucobet.generales.aplication.usecase.state.RetrieveState;


@Service
@Transactional
public class RetrieveStateInteractorImpl implements RetrieveStateInteractor {

	private RetrieveState retrieveState;

	public RetrieveStateInteractorImpl(RetrieveState retrieveState) {
		this.retrieveState = retrieveState;
	}

	@Override
	public List<RetrieveStateDTO> execute(RetrieveStateDTO data) {

		var stateDomain = StateDtoMapper.INSTANCE.dtoToDomain(data);
		var resultados = retrieveState.execute(stateDomain);

		return StateDtoMapper.INSTANCE.domainToDtoCollection(resultados);
	}
}
