package com.demo.monolithic_spring_security_product.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.monolithic_spring_security_product.entity.AuthUser;

@Repository
public interface AuthUserDao extends JpaRepository<AuthUser, Integer>{
	Optional<AuthUser> findByAuthUsername(String authUsername);
}
