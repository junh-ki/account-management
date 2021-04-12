package com.jun.restservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.restservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
