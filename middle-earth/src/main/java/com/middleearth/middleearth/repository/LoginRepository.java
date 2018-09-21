package com.middleearth.middleearth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.middleearth.middleearth.model.User;

public interface LoginRepository extends JpaRepository<User, Long> {
	User findOneByLogin(String userLogin);
	User findOneById(Long userId);
}
