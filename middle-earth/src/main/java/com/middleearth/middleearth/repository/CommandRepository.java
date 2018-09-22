package com.middleearth.middleearth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.model.Command;

public interface CommandRepository extends JpaRepository<Command, Long> {
	List<Command> findByRace(RaceEN race);
}
