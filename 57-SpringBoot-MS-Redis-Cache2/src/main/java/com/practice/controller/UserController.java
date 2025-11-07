package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.User;
import com.practice.service.UserService;

@RestController

public class UserController {

	@Autowired
	private UserService service;
	
	
	@GetMapping(value="/allUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUser = service.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	@GetMapping(value="/user/{id}")
	public ResponseEntity<User> getAllUserById(@PathVariable Long id){
		User allUserById = service.getAllUserById(id);
		return ResponseEntity.ok(allUserById);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<User> creteUser(@RequestBody User user){
		User user2 = service.createUser(user);
		return ResponseEntity.ok(user2);
	}
	
	@DeleteMapping(value="/delete")
	public void deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
	}
}
