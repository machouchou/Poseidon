package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.User;

public interface IUserService {
	
	List<User> findAll();
	
	User findByUsername(String username);

	Boolean existsByUsername(String username);

	public void save(User user);
}
