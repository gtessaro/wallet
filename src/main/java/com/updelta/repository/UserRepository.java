package com.updelta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.updelta.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmailEquals(String Email);
	
}
