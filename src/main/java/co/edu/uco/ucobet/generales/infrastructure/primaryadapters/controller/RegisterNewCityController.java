
package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.ucobet.generales.aplication.primaryports.dto.CityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.RetrieveCityInteractor;
import co.edu.uco.ucobet.generales.crosscuting.exception.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CityResponse;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.MessageService;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.EmailService;

@RestController
@RequestMapping("/general/api/v1/cities")
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterNewCityController {
	


	private final RegisterNewCityInteractor registerNewCityInteractor;
	private final RetrieveCityInteractor retrieveCityInteractor;
	private final MessageService messageService;
	private final EmailService emailService;
	
	public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor,
			final RetrieveCityInteractor retrieveCityInteractor, final MessageService messageService, EmailService emailService) {
		this.registerNewCityInteractor = registerNewCityInteractor;
		this.retrieveCityInteractor = retrieveCityInteractor;
		this.messageService = messageService;
        this.emailService = emailService;
	}

	@PostMapping
	public ResponseEntity<CityResponse> crear(@RequestBody RegisterNewCityDTO dto) {
		var httpStatusCode = HttpStatus.CREATED;
		var ciudadResponse = new CityResponse();

		try {
			registerNewCityInteractor.execute(dto);
			ciudadResponse.getMensajes().add(messageService.getMessageContent("M001"));
			
			emailService.sendEmailNotification(dto.getCityName());

		} catch (final UcobetException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getUserMessage());

		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			ciudadResponse.getMensajes().add(messageService.getMessageContent("M002"));
		}

		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}

	@GetMapping
	public ResponseEntity<CityResponse> consultar() {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var cityResponse = new CityResponse();
		try {
			var cityDto = CityDTO.create();
			cityResponse.setDatos(retrieveCityInteractor.execute(cityDto));
			cityResponse.getMensajes().add(messageService.getMessageContent("M006"));
		} catch (final UcobetException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			cityResponse.getMensajes().add(messageService.getMessageContent("M007"));
			exception.printStackTrace();

		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			cityResponse.getMensajes().add(messageService.getMessageContent("M008"));
			exception.printStackTrace();
		}
		return new ResponseEntity<>(cityResponse, httpStatusCode);
	}
}
