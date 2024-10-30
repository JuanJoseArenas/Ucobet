package co.edu.uco.ucobet.generales.aplication.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscuting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Country")
public final class CountryEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	CountryEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public CountryEntity(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	public static final CountryEntity create() {
		return new CountryEntity();
	}
	
	
	public static final CountryEntity create(final UUID id, final String name) {
		return new CountryEntity(id, name);
	}
	
	public static final CountryEntity create(final UUID id) {
		return new CountryEntity(id, TextHelper.EMPTY);
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

}
