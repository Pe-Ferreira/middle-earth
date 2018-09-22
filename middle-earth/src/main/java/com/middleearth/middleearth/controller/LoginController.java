package com.middleearth.middleearth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.enums.RegionEN;
import com.middleearth.middleearth.model.User;
import com.middleearth.middleearth.service.LoginService;
import com.middleearth.middleearth.service.OrcService;

@RequestMapping("/")
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private OrcService orcService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		if(this.loginService.checkSuperUser()) {
			return "login";
		}
		this.loginService.createSuperUser();
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String login, @RequestParam String password) {
		User user = this.loginService.findOneByLogin(login);
		if(user != null && user.isActive()) {
			return "redirect:/dashboard/" + user.getId();
		}
		return "LOGIN INVALIDO";
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("racesEN", RaceEN.values());
		model.addAttribute("regionEN", RegionEN.values());
		return "sign-up";
	}

}
