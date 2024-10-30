package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.crosscuting.exception.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.StateResponse;


@RestController
@RequestMapping("/general/api/v1/states")
public class RetrieveStateController {
	
	private RetrieveStateInteractor retrieveStateInteractor;
	
	public RetrieveStateController(RetrieveStateInteractor retrieveStateInteractor) {
		this.retrieveStateInteractor = retrieveStateInteractor;
	}
	
	@GetMapping
	public ResponseEntity<StateResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var stateResponse = new StateResponse();
	try {
		var stateDto = RetrieveStateDTO.create();
		stateResponse.setDatos(retrieveStateInteractor.execute(stateDto));
		stateResponse.getMensajes().add("Estados Consultados Satisfactoriamente");
	}catch (final UcobetException exception) {
		httpStatusCode = HttpStatus.BAD_REQUEST;
		stateResponse.getMensajes().add("\"Se ha presentado una SQLException tratando de realizar la consulta de los departamentos en la tabla \\\"State\\\" de la base de datos.\"");
		exception.printStackTrace();
		
	}catch(final Exception exception) {
		httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		var mensajeUsusario = "Se ha presentado un problema al consultar la información de los estados";
		stateResponse.getMensajes().add(mensajeUsusario);
		exception.printStackTrace();
	}
	return new ResponseEntity<>(stateResponse, httpStatusCode);
	}
}