package co.edu.uco.ucobet.generales.aplication.primaryports.interactor;

import org.springframework.stereotype.Service;

@Service
public interface InteractorWithoutReturn <T>{
	void execute(T data);

}
