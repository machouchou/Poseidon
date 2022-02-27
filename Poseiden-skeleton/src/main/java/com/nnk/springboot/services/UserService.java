package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserService {
	
	final Logger logger = LogManager.getLogger(UserService.class);

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() { 
		logger.debug("User List");
		return userRepository.findAll();
	}
	
	public User save(User user) {
		logger.debug("User saved");
		 return userRepository.save(user);
	}
	public Optional<User> findById(Integer id) {
		logger.debug("User found By Id");
		 return userRepository.findById(id);
	}
	
	public void delete(User user) {
		logger.debug("User removed");
		 userRepository.delete(user);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}



}
