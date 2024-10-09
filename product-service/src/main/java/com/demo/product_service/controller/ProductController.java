package com.demo.product_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.product_service.model.ProductPojo;

@RestController
@RequestMapping("/api")
public class ProductController {

	List<ProductPojo> allProducts = List.of(new ProductPojo(101, "Mobile"), new ProductPojo(102, "Laptop"));
	
	@GetMapping("/products")
	public List<ProductPojo> getAllProducts(){
		return allProducts;
	}
}
