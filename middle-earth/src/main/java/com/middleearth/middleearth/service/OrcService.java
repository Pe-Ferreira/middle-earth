package com.middleearth.middleearth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.enums.RegionEN;
import com.middleearth.middleearth.model.Orc;
import com.middleearth.middleearth.repository.OrcRepository;

@Service
public class OrcService {

	@Autowired
	OrcRepository orcRepository;

	public void createRandomOrcsForTests() {
		for(int i = 0; i < 3; i++) {
			Orc orc = new Orc();
			orc.setLogin("orc " + i);
			orc.setPassword("orc" + i);
			orc.setRace(RaceEN.ORC);
			this.persistOrc(orc);
			System.out.println(orc.getLogin());
		}
	}

	public void persistOrc(Orc orc) {
		this.orcRepository.save(orc);
	}

	public Orc findOneByLogin(String orcLogin) {
		return this.orcRepository.findOneByLogin(orcLogin);
	}

	public Orc findById(Long orcId) {
		return this.orcRepository.findOneById(orcId);
	}

	public List<Orc> list(){
		return this.orcRepository.findAll();
	}

	public void createAndPersistOrc(String login, String password, String race, String region) {
		Orc orc = new Orc();
		orc.setLogin(login);
		orc.setPassword(password);
		orc.setActive(true);
		orc.setRace(RaceEN.ORC);
		orc.setRegion(RegionEN.valueOf(region));
		this.persistOrc(orc);
	}
}
