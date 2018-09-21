package com.middleearth.middleearth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.middleearth.middleearth.model.Orc;
import com.middleearth.middleearth.repository.OrcRepository;

@Service
public class OrcService {

	@Autowired
	OrcRepository orcRepository;

	public void persistOrc(Orc orc) {
		this.orcRepository.save(orc);
	}

	public Orc findOneByLogin(String orcLogin) {
		return this.orcRepository.findOneByLogin(orcLogin);
	}

	public Orc findById(Long orcId) {
		return this.orcRepository.findOneById(orcId);
	}
}
