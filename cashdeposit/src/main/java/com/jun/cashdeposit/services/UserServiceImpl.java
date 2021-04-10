package com.jun.cashdeposit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.cashdeposit.entities.User;
import com.jun.cashdeposit.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
