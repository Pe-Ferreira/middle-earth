package com.middleearth.middleearth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.enums.RegionEN;
import com.middleearth.middleearth.model.User;
import com.middleearth.middleearth.service.LoginService;

@Controller
public class UserController {
	@Autowired
	private LoginService loginService;

	@RequestMapping("/dashboard/{userId}")
	public String dashboard(@PathVariable Long userId) {
		User user = this.loginService.findById(userId);
		if(user.getRace().equals(RaceEN.ISTARI)) {
			return "admin";
		} else {
			return "troops";
		}
	}

	@RequestMapping("/dashboard/admin/send-command")
	public String sendCommand(String race, String command) {
		//persistir comando para grupo X
		return "";
	}

	@RequestMapping("/dashboard/admin/switch-orc-region/{orcId}/{newRegion}")
	public void switchOrcRegion(Long orcId, String newRegion) {
		User user = this.loginService.findById(orcId);
		user.setRegion(RegionEN.valueOf(newRegion));
		this.loginService.persistUser(user);
	}

	@RequestMapping("/dashboard/admin/join-other-group/{orcId}/{newGroup}")
	public void joinOrcToOtherGroup(Long orcId, String newGroup) {
		User user = this.loginService.findById(orcId);
		if(user != null && user.getRace().equals(RaceEN.ORC)) {
			user.setBattleGroup(RaceEN.valueOf(newGroup));
			this.loginService.persistUser(user);
		}
	}

	@RequestMapping("/dashboard/admin/remove-orc/{orcId}")
	public void removeOrcFromTroops(Long orcId) {
		User user = this.loginService.findById(orcId);
		if(user != null) {
			user.setActive(false);
		}
	}

	@RequestMapping("/dashboard/troops/execute/{commandId}")
	public String executeCommand(Long commandId) {
		return "";
	}
}
