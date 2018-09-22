package com.middleearth.middleearth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.model.Command;
import com.middleearth.middleearth.repository.CommandRepository;

@Service
public class CommandService {

	@Autowired
	CommandRepository commandRepository;

	public void persistCommand(Command command) {
		this.commandRepository.save(command);
	}

	public void createAndPersistCommand(String command, RaceEN race) {
		Command goblinCommand = new Command();
		goblinCommand.setCommand(command);
		goblinCommand.setRace(race);
		this.persistCommand(goblinCommand);
	}

	public List<Command> commandsByRace(RaceEN race){
		return this.commandRepository.findByRace(race);
	}
}
