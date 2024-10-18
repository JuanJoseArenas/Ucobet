package co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.InteractorWithoutReturn;

@Transactional
@Service
public interface RegisterNewCityInteractor extends InteractorWithoutReturn<RegisterNewCityDTO> { 

}
