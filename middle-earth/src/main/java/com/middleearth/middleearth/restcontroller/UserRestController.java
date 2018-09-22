package com.middleearth.middleearth.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.model.Command;
import com.middleearth.middleearth.model.Orc;
import com.middleearth.middleearth.service.CommandService;
import com.middleearth.middleearth.service.OrcService;

@RestController
public class UserRestController {

	private final String GOBLIN_KEY = "G";
	private final String URUKHAI_KEY = "U";
	private final String SNAGA_KEY = "S";

	@Autowired
	private CommandService commandService;
	@Autowired
	private OrcService orcService;

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

	@RequestMapping(value = "/dashboard/troops/execute/", method = RequestMethod.POST)
	public String executeCommand(@RequestParam Long commandId) {
		Command command = this.commandService.findById(commandId);
		command.setExecuted(true);
		return "Executed!";
	}

	@RequestMapping(value = "/dashboard/admin/remove-orc", method = RequestMethod.POST)
	public String removeOrcFromTroops(@RequestParam Long orcId) {
		Orc orc = this.orcService.findById(orcId);
		if(orc != null) {
			orc.setActive(false);
		}
		return "Orc removed from army!";
	}
}
