package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.crosscuting.exception.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.StateResponse;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.MessageService;


@RestController
@RequestMapping("/general/api/v1/states")
@CrossOrigin(origins = "http://localhost:4200")
public class RetrieveStateController {
	
	private RetrieveStateInteractor retrieveStateInteractor;
	private final MessageService messageService;
	
	public RetrieveStateController(RetrieveStateInteractor retrieveStateInteractor, final MessageService messageService) {
		this.retrieveStateInteractor = retrieveStateInteractor;
		this.messageService = messageService;
	}
	
	@GetMapping
	public ResponseEntity<StateResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var stateResponse = new StateResponse();
	try {
		var stateDto = RetrieveStateDTO.create();
		stateResponse.setDatos(retrieveStateInteractor.execute(stateDto));
		stateResponse.getMensajes().add(messageService.getMessageContent("M003"));
	}catch (final UcobetException exception) {
		httpStatusCode = HttpStatus.BAD_REQUEST;
		stateResponse.getMensajes().add(messageService.getMessageContent("M004"));
		exception.printStackTrace();
		
	}catch(final Exception exception) {
		httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		stateResponse.getMensajes().add(messageService.getMessageContent("M005"));
		exception.printStackTrace();
	}
	return new ResponseEntity<>(stateResponse, httpStatusCode);
	}
}