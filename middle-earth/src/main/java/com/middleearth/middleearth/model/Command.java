package com.middleearth.middleearth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.middleearth.middleearth.enums.RaceEN;

@Entity
@Table
public class Command {
	private static final long serialVersionUID = -5256244914076328803L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
	@Column
	private Long id;

	@Column
	private String command;

	@Column
	private RaceEN race;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommand() {
		return this.command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public RaceEN getRace() {
		return this.race;
	}

	public void setRace(RaceEN race) {
		this.race = race;
	}


}
