package co.edu.uco.ucobet.generales.aplication.primaryports.interactor;

import org.springframework.stereotype.Service;

@Service
public interface InteractorWithReturn <T, R>{
	R execute(T data);

}
