package com.middleearth.middleearth.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.service.LoginService;
import com.middleearth.middleearth.service.OrcService;

@RestController
public class LoginRestController {

	@Autowired
	private OrcService orcService;
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/sign-up/new-user", method = RequestMethod.POST)
	public String newUser(@RequestParam String login, @RequestParam String password,
			@RequestParam String race, @RequestParam String region) {
		if(race.equals(RaceEN.ORC.toString())) {
			this.orcService.createAndPersistOrc(login, password, race, region);
		} else {
			this.loginService.createAndPersistUser(login, password, race, region);
		}
		return "Soldier Successfully Created! Redirecting to Home Page.";
	}
}
