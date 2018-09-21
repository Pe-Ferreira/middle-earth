package com.middleearth.middleearth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
