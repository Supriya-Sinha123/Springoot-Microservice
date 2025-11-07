package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class UserService {
	
	@Autowired
	ExternalUserService externalUserService;

	@CircuitBreaker(name="userService", fallbackMethod="getUserfallBack")
	public UserDTO getUserById(Long id) {
		UserDTO userById = externalUserService.getUserById(id);
		return userById;
	}
	
	public UserDTO getUserfallBack(Long id, Exception ex) {
		return new UserDTO(id, "User"+id, id+"@gmail.com");
	}
	
	@CircuitBreaker(name="userService", fallbackMethod="getAllUserfallBack")
	@TimeLimiter(name="userService")
	public List<UserDTO> getAllUsers(){
		List<UserDTO> allUsers = externalUserService.getAllUsers();
		return allUsers;
	}
	
	
	public List<UserDTO> getAllUserfallBack(Exception ex){
		return List.of(
				new UserDTO(11l, "John", "john@gmail.com"),
				new UserDTO(22l,"Mary", "mary@gmail.com")
				);
	}
	
}
