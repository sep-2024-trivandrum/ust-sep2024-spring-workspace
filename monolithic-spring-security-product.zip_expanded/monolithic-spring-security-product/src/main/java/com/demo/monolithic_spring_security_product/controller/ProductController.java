package com.demo.monolithic_spring_security_product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.monolithic_spring_security_product.entity.Product;
import com.demo.monolithic_spring_security_product.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired 
	ProductService prodService;
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return prodService.getAllProducts();
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/products/{pid}")
	public Product getAProduct(@PathVariable("pid") int prodId) {
		return prodService.getAProduct(prodId);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product newProd) {
		return prodService.addProduct(newProd);
	}
}
