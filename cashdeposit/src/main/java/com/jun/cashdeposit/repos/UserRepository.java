package com.jun.cashdeposit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.cashdeposit.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
