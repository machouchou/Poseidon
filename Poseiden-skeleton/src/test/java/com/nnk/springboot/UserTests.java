package com.nnk.springboot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.UserService;

public class UserTests {
	
	private UserRepository userRepository =Mockito.mock(UserRepository.class);

	private static UserService userService;
	
	@Test
	public void saveUser() {
		
		userService = new UserService(userRepository); 
		
		User user = new User();
		user.setFullname("CarlaLopes");
		user.setPassword("J@va1234");
		user.setRole("user");
		user.setUsername("Carla");
		user.setId(6);
		
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		
		User userResult = userService.save(user);
		assertNotNull(userResult.getPassword());
		assertEquals(user.getId(), userResult.getId());
	}
	
	@Test
	public void findAllUser() {
		
		userService = new UserService(userRepository); 
		
		User user1 = new User();
		user1.setFullname("GeremyLopes");
		user1.setPassword("Geremy_123");
		user1.setRole("user");
		user1.setUsername("Geremy");
		user1.setId(7);
		
		User user2 = new User();
		user2.setFullname("AlexLopes");
		user2.setPassword("Alex_123");
		user2.setRole("user");
		user2.setUsername("Alex");
		user2.setId(8);
		
		List<User> lUser = new ArrayList<>();
		lUser.add(user1);
		lUser.add(user2);
		
		when(userRepository.findAll()).thenReturn(lUser);
		
		List<User> users = userService.findAll();
		
		assertNotNull(users.size());
		assertEquals(2, users.size());
		assertTrue(users.contains(user1));
	}
	
	@Test
	public void findById() {
		
		userService = new UserService(userRepository);
		
		User user = new User();
		user.setFullname("CarlaLopes");
		user.setPassword("J@va1234");
		user.setRole("user");
		user.setUsername("Carla");
		user.setId(6);
		
		Optional<User> optResult = Optional.of(user);
		
		when(userRepository.findById(6)).thenReturn(optResult);
		
		Optional<User> optUser = userService.findById(6);
		
		assertNotNull(user.getId());
		assertEquals(optResult.get().getId(), optUser.get().getId());
	}
	
	@Test
	public void deleteUser() {
		
		userService = new UserService(userRepository);
		User user = new User();
		user.setFullname("CarlaLopes");
		user.setPassword("J@va1234");
		user.setRole("user");
		user.setUsername("Carla");
		user.setId(6);
		Optional<User> userResult = userRepository.findById(6);
		assertFalse(userResult.isPresent());
		doNothing().when(userRepository).delete(Mockito.any(User.class));
		userService.delete(user);
		verify(userRepository, times(1)).delete(Mockito.any(User.class));
	}
}
