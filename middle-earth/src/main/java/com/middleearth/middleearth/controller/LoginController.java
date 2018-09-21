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

@RequestMapping("/")
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		User superUser = new User();
		superUser.setLogin("Saruman");
		superUser.setPassword("123");
		superUser.setRace(RaceEN.ISTARI);
		superUser.setActive(true);
		this.loginService.persistUser(superUser);

		User trooper = new User();
		trooper.setLogin("Orc");
		trooper.setPassword("321");
		trooper.setRace(RaceEN.ORC);
		trooper.setActive(true);
		this.loginService.persistUser(trooper);
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

	@RequestMapping(value = "/sign-up/new-user", method = RequestMethod.POST)
	public String newUser(@RequestParam String login, @RequestParam String password, @RequestParam String race) {
		User user = new User(login, password, RaceEN.valueOf(race));
		this.loginService.persistUser(user);
		System.out.println(user);
		return "login";
	}
}
