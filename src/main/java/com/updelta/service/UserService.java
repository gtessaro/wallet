package com.updelta.service;

import java.util.Optional;

import com.updelta.entity.User;

public interface UserService {

	User save(User u);
	Optional<User> findByEmail(String email);
	
}
