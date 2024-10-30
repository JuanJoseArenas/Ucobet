package co.edu.uco.ucobet.generales.aplication.primaryports.dto;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscuting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.UUIDHelper;

public class CountryDTO {
	
	private UUID id;
	private String name;
	
	
	public CountryDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	public static CountryDTO create(final UUID id, final String name) {
		return new CountryDTO(id, name);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);		
	}
	
	

}
