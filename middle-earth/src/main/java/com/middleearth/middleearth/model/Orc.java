package com.middleearth.middleearth.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.middleearth.middleearth.enums.RaceEN;

@Entity
public class Orc extends User{

	private static final long serialVersionUID = -5256244914076328803L;

	@Column
	private RaceEN battleGroup;

	public RaceEN getBattleGroup() {
		return this.battleGroup;
	}

	public void setBattleGroup(RaceEN battleGroup) {
		this.battleGroup = battleGroup;
	}

}
