package com.practice.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="product")
@Data
public class ProductEntity {

	@Id
	@GeneratedValue(generator="product-id-generator")
	@GenericGenerator(name="product-id-generator", strategy="com.practice.util.GenerateId")
	private String id;
	private String name;
	private String model;
	private String price;
	private int warranty;
	private LocalDate mfd;
}
