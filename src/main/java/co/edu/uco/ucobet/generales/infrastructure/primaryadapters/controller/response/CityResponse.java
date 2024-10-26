package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.CityDTO;

public class CityResponse extends Response<CityDTO>{
	
	public CityResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
