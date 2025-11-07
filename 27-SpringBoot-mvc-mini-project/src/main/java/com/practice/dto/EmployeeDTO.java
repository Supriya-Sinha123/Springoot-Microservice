package com.practice.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class EmployeeDTO {

	private long id;
	
	@NotBlank(message="firstname ie required")
	private String firstName;
	private String lastName;
	@Email(message="invalid email")
	@NotBlank(message="email is required")
	private String email;
	@Size(min=6, message="password must be at least 6 char or int")
	private String password;
	@NotBlank(message="gender is required")
	private String gender;
	
}
