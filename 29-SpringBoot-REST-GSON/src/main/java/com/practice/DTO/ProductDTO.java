package com.practice.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private int id;
	private String name;
	private double price;
	private String brand;
	private transient String productCode;
	private Date createdAt;
}
