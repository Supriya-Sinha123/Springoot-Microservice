package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.UserDTO;
import com.practice.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
		UserDTO userById = service.getUserById(id);
		return ResponseEntity.ok(userById);
	}
}
