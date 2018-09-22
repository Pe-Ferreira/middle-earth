package com.middleearth.middleearth.service;

import java.util.List;
import java.util.Random;

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

	public void createRandomCommandsForTests() {
		Random randomizer = new Random();
		for(int i = 0; i < 10; i++) {
			Command command = new Command();
			command.setRace(RaceEN.values()[randomizer.nextInt(5)]);
			command.setCommand("Command number " + i);
			this.persistCommand(command);
			System.out.println(command.getCommand() + " / " + command.getRace());
		}
	}

	public void createAndPersistCommand(String command, RaceEN race) {
		Command goblinCommand = new Command();
		goblinCommand.setCommand(command);
		goblinCommand.setRace(race);
		this.persistCommand(goblinCommand);
	}

	public List<Command> commandsByRace(RaceEN race){
		return this.commandRepository.findByRaceAndExecuted(race, false);
	}

	public Command findById(Long commandId) {
		return this.commandRepository.findOneById(commandId);
	}
}
