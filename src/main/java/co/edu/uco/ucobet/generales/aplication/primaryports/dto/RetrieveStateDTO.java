package co.edu.uco.ucobet.generales.aplication.primaryports.dto;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscuting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.UUIDHelper;

public class RetrieveStateDTO {
	
	private UUID id; 
	private String name;
	private CountryDTO country;
	
	public RetrieveStateDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setCountry(country);
	}
	
	
	
	public RetrieveStateDTO(UUID id, String name, CountryDTO country) {
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	public static RetrieveStateDTO create () {
		return new RetrieveStateDTO();
	}
	
	public static  RetrieveStateDTO create(UUID id, String name, CountryDTO country) {
		return new RetrieveStateDTO(id, name, country);
		
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



	public CountryDTO getCountry() {
		return country;
	}



	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	

}
