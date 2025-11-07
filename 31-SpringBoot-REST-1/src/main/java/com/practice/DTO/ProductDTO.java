package com.practice.DTO;

import java.time.LocalDate;

import com.practice.utility.ProductType;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDTO {

	@XmlElement
	private long id;
	@XmlElement
	private String name;
	@XmlElement
	private String brand;
	@XmlElement
	private int warranty;
	@XmlElement
	private int price;
	@XmlElement
	private int quantity;
	@XmlElement
	private LocalDate mfd;
	@XmlElement
	private ProductType type;
}
