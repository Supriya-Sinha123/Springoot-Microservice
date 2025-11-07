package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.dto.ProductDTO;
import com.practice.service.ProductService;
import com.practice.utility.ProductType;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(name="/")
	public String getRegisterProduct(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("type", ProductType.values());
		return "register";
	}
	
	@PostMapping(value="/register", name="register the product")
	public String saveProduct(@ModelAttribute("product") ProductDTO product) {
		productService.registerProduct(product);
		return "redirect:/list_product";
	}
	
	@GetMapping(value="/list_product")
	public String getListOfProduct(Model model) {
		List<ProductDTO> fetchAllProduct = productService.fetchAllProduct();
		model.addAttribute("listProduct", fetchAllProduct);
		return "listproduct";
	}
	
	@GetMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable("id")Long id) {
		productService.deleteProduct(id);
		return "redirect:/list_product";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editProduct(@PathVariable("id")Long id,Model model) {
		ProductDTO productById = productService.fetchProductById(id);
		model.addAttribute("product", productById);
		model.addAttribute("type", ProductType.values());
		return "edit";
	}
	
	@PostMapping(value="/update")
	public String updateProduct(@ModelAttribute("product")ProductDTO product, Model model) {
		productService.updateProduct(product);
		return "redirect:/list_product";
	}
	
	
}
