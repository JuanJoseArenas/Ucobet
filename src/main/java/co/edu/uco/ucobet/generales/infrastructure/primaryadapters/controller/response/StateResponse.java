package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RetrieveStateDTO;

public class StateResponse extends Response<RetrieveStateDTO>{
	
	public StateResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
