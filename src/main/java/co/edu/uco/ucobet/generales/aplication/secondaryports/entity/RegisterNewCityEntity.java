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
@Table (name = "City")
public final class RegisterNewCityEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column (name = "name")
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name= "state")
	private StateEntity state;


	RegisterNewCityEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setState(StateEntity.create());
	}


	public RegisterNewCityEntity(UUID id, String name, StateEntity state) {
		setId(id);
		setName(name);
		setState(state);
	}
	
	static final RegisterNewCityEntity create() {
		return new RegisterNewCityEntity();
	}
	
	
	public static final RegisterNewCityEntity create(final UUID id, final String name, final StateEntity state) {
		return new RegisterNewCityEntity(id, name, state);
	}
	
	public static final RegisterNewCityEntity create(final UUID id) {
		return new RegisterNewCityEntity(id, TextHelper.EMPTY, StateEntity.create());
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


	public StateEntity getState() {
		return state;
	}


	public void setState(final StateEntity state) {
		this.state = ObjectHelper.getDefault(state, StateEntity.create());
	}
	

}