package com.practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="profile")
public class ProfileEntity {

	@Id
	@GeneratedValue
	private long id;
	private String bio;
	private String phone;
}
