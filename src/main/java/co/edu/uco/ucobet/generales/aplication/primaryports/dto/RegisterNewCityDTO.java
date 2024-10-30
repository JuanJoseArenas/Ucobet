package co.edu.uco.ucobet.generales.aplication.primaryports.dto;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscuting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.UUIDHelper;

public final class RegisterNewCityDTO {
	private String cityName;
	private UUID stateId;

	

	public RegisterNewCityDTO(final String cityName, final UUID stateId) {
		setStateId(stateId);
		setCityName(cityName);
	}
	
	public static RegisterNewCityDTO create(final String cityName, final UUID stateId) {
		return new RegisterNewCityDTO(cityName, stateId);
	}

	private void setCityName(String cityName) {
		this.cityName = TextHelper.applyTrim(cityName);
	}

	private void setStateId(UUID stateId) {
		this.stateId = UUIDHelper.getDefault(stateId, UUIDHelper.getDefault());
	}

	public String getCityName() {
		return cityName;
	}

	public UUID getStateId() {
		return stateId;
	}

}
