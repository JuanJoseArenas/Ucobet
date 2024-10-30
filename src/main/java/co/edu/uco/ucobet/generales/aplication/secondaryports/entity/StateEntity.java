package co.edu.uco.ucobet.generales.aplication.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscuting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscuting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "State")
public final class StateEntity {

	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "conutry")
	private CountryEntity country;

	StateEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setCountry(CountryEntity.create());
	}

	public StateEntity(final UUID id, final String name, final CountryEntity country) {
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	public static final StateEntity create() {
		return new StateEntity();
	}
	
	
	public static final StateEntity create(final UUID id, final String name, final CountryEntity country) {
		return new StateEntity(id, name, country);
	}
	
	public static final StateEntity create(final UUID id) {
		return new StateEntity(id, TextHelper.EMPTY, CountryEntity.create());
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

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(final CountryEntity country) {
		this.country = ObjectHelper.getDefault(country, CountryEntity.create());
	}

}