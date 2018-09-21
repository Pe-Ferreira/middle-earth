package com.middleearth.middleearth.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.service.CommandService;

@RestController
public class UserRestController {

	private final String GOBLIN_KEY = "G";
	private final String URUKHAI_KEY = "U";
	private final String SNAGA_KEY = "S";

	@Autowired
	private CommandService commandService;

	@RequestMapping(value = "/dashboard/admin/send-command", method = RequestMethod.POST)
	public String sendCommand(@RequestParam String raceKey, @RequestParam String command) {
		if(raceKey.equals(this.GOBLIN_KEY)) {
			this.commandService.createAndPersistCommand(command, RaceEN.GOBLIN);
		} else if(raceKey.equals(this.URUKHAI_KEY)) {
			this.commandService.createAndPersistCommand(command, RaceEN.URUKHAI);
		} else if(raceKey.equals(this.SNAGA_KEY)) {
			this.commandService.createAndPersistCommand(command, RaceEN.SNAGA);
		}
		return "Command sended!";
	}
}
