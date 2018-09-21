package com.middleearth.middleearth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.middleearth.middleearth.model.Orc;

public interface OrcRepository extends JpaRepository<Orc, Long> {
	Orc findOneByLogin(String orcLogin);
	Orc findOneById(Long orcId);
}
