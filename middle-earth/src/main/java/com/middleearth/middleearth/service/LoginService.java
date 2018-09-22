package com.middleearth.middleearth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.middleearth.middleearth.enums.RaceEN;
import com.middleearth.middleearth.enums.RegionEN;
import com.middleearth.middleearth.model.User;
import com.middleearth.middleearth.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public void persistUser(User user) {
		this.loginRepository.save(user);
	}

	public User findOneByLogin(String userLogin) {
		return this.loginRepository.findOneByLogin(userLogin);
	}

	public User findById(Long userId) {
		return this.loginRepository.findOneById(userId);
	}

	public boolean checkSuperUser() {
		User saruman = this.loginRepository.findOneByLogin("Saruman");
		if(saruman != null){
			return true;
		}
		return false;
	}

	public void createSuperUser() {
		User superUser = new User();
		superUser.setLogin("Saruman");
		superUser.setPassword("123");
		superUser.setRace(RaceEN.ISTARI);
		superUser.setActive(true);
		this.persistUser(superUser);
	}

	public void createAndPersistUser(String login, String password, String race, String region) {
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setActive(true);
		user.setRace(RaceEN.valueOf(race));
		user.setRegion(RegionEN.valueOf(region));
		this.persistUser(user);
	}
}
