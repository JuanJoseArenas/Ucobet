package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscuting.helpers.UUIDHelper;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {
	
	private RegisterNewCityInteractor registerNewCityInteractor;
	
	public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor) {
		super();
		this.registerNewCityInteractor = registerNewCityInteractor;
	}

	@PostMapping
	public RegisterNewCityDTO execute(@RequestBody RegisterNewCityDTO dto) {
//		registerNewCityInteractor.execute(dto);
		
		//Cuidado aquí: Recuerde definir el servicio siguiendo buenas prácticas y asegurando que se retornen los mensajes 
		//y codigos HHTPS adecuados, garantizando que la estrategia REST está orientada a la buena práctica.
		
		return dto;
	}
	
	@GetMapping
	public RegisterNewCityDTO executeDummy() {
		return RegisterNewCityDTO.create("Rionegro", UUIDHelper.generate());
	}

}