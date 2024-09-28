package com.demo.monolithic_spring_security_product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.monolithic_spring_security_product.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}
