package com.practice.dto;

import java.time.LocalDate;

import com.practice.utility.ProductType;

import lombok.Data;


@Data
public class ProductDTO {

	
	private long id;
	private String name;
	private String brand;
	private int warrnaty;
	private int quantity;
	private int price;
	private LocalDate mfd;
	private ProductType type;
}
