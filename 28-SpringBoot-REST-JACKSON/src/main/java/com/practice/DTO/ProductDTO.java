package com.practice.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	@JsonProperty("product_id")
	private int id;
	private String name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private double price;
	private String brand;
	@JsonIgnore
	private String productCode;
}
