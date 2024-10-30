package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CityResponse;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {
	

    private final RegisterNewCityInteractor registerNewCityInteractor;
    private final RetrieveCityInteractor retrieveCityInteractor;

    public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor,
                                     final RetrieveCityInteractor retrieveCityInteractor) {
        this.registerNewCityInteractor = registerNewCityInteractor;
        this.retrieveCityInteractor = retrieveCityInteractor;
    }

	@PostMapping
    public ResponseEntity<CityResponse> crear(@RequestBody RegisterNewCityDTO dto) {

        var httpStatusCode = HttpStatus.CREATED;
        var ciudadResponse = new CityResponse();

        try {
            registerNewCityInteractor.execute(dto);
            ciudadResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00008));

        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            ciudadResponse.getMensajes().add(excepcion.getUserMessage());
            
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00009);
            ciudadResponse.getMensajes().add(mensajeUsuario);
        }

        return new ResponseEntity<>(ciudadResponse , httpStatusCode);

    }
	
	@GetMapping
	public ResponseEntity<CityResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var cityResponse = new CityResponse();
	try {
		var cityDto = CityDTO.create();
		cityResponse.setDatos(retrieveCityInteractor.execute(cityDto));
		cityResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00013));
	}catch (final UcobetException exception) {
		httpStatusCode = HttpStatus.BAD_REQUEST;
		cityResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00014));
		exception.printStackTrace();
		
	}catch(final Exception exception) {
		httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		var mensajeUsusario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00015);
		cityResponse.getMensajes().add(mensajeUsusario);
		exception.printStackTrace();
	}
	return new ResponseEntity<>(cityResponse, httpStatusCode);
	}
}