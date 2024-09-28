package com.demo.monolithic_spring_security_product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="product_details")
public class Product {
	@Id
	@Column(name="prod_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	
	@Column(name="prod_name")
	private String prodName;
	
}
