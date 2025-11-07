package com.practice.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;

@Service
public class ExternalUserService {

	
	private final Random random = new Random();
	
	public UserDTO getUserById(Long id) {
		try {
			Thread.sleep(500+random.nextInt(1000));
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		return new UserDTO(id, "User"+id, id+"@gmail.com");
	}
	
	
	public List<UserDTO> getAllUsers() {
		try {
			Thread.sleep(500+random.nextInt(1000));
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		return List.of(
				new UserDTO(1l, "Supriya", "supriya@gmail.com"),
				new UserDTO(2l,"Sima", "sima@gmail.com")
				);
		
	}
}
