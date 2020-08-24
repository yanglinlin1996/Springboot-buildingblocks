package com.linlinyang.restservices.springbootbuildingblocks.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linlinyang.restservices.springbootbuildingblocks.entities.User;
import com.linlinyang.restservices.springbootbuildingblocks.repositories.UserRepository;

// Service
@Service
public class UserService {

	// Autowire the UserRepository
	
	@Autowired
	private UserRepository userRepository;
	
	// getAllUsers Method
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	// CreateUser Method
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	// getUserById
	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	// updateUserById
	public User updateUserById(User user, Long id) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	// deleteUserById
	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	// getUserByUsername
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
