package com.practice.entity;

import java.time.LocalDate;

import com.practice.utility.ProductType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Restproduct")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String brand;
	private int warranty;
	private int price;
	private int quantity;
	private LocalDate mfd;
	private ProductType type;
	
}
