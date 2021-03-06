package com.middleearth.middleearth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.enums.RegionEN;
import com.middleearth.middleearth.model.Orc;
import com.middleearth.middleearth.model.User;
import com.middleearth.middleearth.service.CommandService;
import com.middleearth.middleearth.service.LoginService;
import com.middleearth.middleearth.service.OrcService;

@Controller
public class UserController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private OrcService orcService;
	@Autowired
	private CommandService commandService;

	@RequestMapping("/dashboard/{userId}")
	public String dashboard(@PathVariable Long userId, Model model) {
		User user = this.loginService.findById(userId);
		if(user.getRace().equals(RaceEN.ISTARI)) {
			this.orcService.createRandomOrcsForTests();
			model.addAttribute("orcList", this.orcService.list());
			return "admin";
		} else {
			return "redirect:/dashboard/trooper/" + user.getId();
		}
	}

	@RequestMapping("/dashboard/trooper/{userId}")
	public String dashboardTrooper(@PathVariable Long userId, Model model) {
		User user = this.loginService.findById(userId);
		//MOCK COMMANDS FOR TEST PURPOSE
		this.commandService.createRandomCommandsForTests();
		model.addAttribute("title", "THE " + user.getRace().name() + " PANEL");
		model.addAttribute("commandList", this.commandService.commandsByRace(user.getRace()));
		return "troops";
	}

	@RequestMapping("/dashboard/admin/switch-orc-region/{orcId}/{newRegion}")
	public void switchOrcRegion(Long orcId, String newRegion) {
		Orc orc = this.orcService.findById(orcId);
		orc.setRegion(RegionEN.valueOf(newRegion));
		this.loginService.persistUser(orc);
	}

	@RequestMapping("/dashboard/admin/join-other-group/{orcId}/{newGroup}")
	public void joinOrcToOtherGroup(Long orcId, String newGroup) {
		Orc orc = this.orcService.findById(orcId);
		if(orc != null) {
			orc.setBattleGroup(RaceEN.valueOf(newGroup));
			this.orcService.persistOrc(orc);
		}
	}
}
