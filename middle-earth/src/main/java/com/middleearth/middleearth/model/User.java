package com.middleearth.middleearth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.enums.RegionEN;

@Entity
@Table
public class User {

	private static final long serialVersionUID = -5256244914076328803L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
	@Column
	private Long id;

	@NotNull
	@Size(min = 1)
	@Column
	private String login;

	@Column
	private String password;

	@Column
	private RaceEN race;

	public RegionEN getRegion() {
		return this.region;
	}

	public void setRegion(RegionEN region) {
		this.region = region;
	}

	@Column
	private RegionEN region;

	@Column
	private boolean active;

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User() {

	}

	public User(String login, String password, RaceEN race) {
		this.login = login;
		this.password = password;
		this.race = race;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RaceEN getRace() {
		return this.race;
	}

	public void setRace(RaceEN race) {
		this.race = race;
	}
}
