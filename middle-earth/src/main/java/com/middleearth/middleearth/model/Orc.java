package com.middleearth.middleearth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.enums.RegionEN;

@Entity
@Table
public class Orc extends User{

	private static final long serialVersionUID = -5256244914076328803L;

	@Column
	private RegionEN region;

	@Column
	private RaceEN battleGroup;

	public RegionEN getRegion() {
		return this.region;
	}

	public void setRegion(RegionEN region) {
		this.region = region;
	}

	public RaceEN getBattleGroup() {
		return this.battleGroup;
	}

	public void setBattleGroup(RaceEN battleGroup) {
		this.battleGroup = battleGroup;
	}

}
