package com.demo.monolithic_spring_security_product.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.demo.monolithic_spring_security_product.entity.Roles;

//@Service
public class CustomUserDetails implements UserDetails{

	private String name;
	private String password;
	private List<SimpleGrantedAuthority> allRoles;
	
	public CustomUserDetails(String name, String password, List<Roles> allRoles) {
		this.name = name;
		this.password = password;
		// assigning a collection of Roles to a collection of SimpleGrantedAuthority
		this.allRoles = allRoles.stream().map((role)-> new SimpleGrantedAuthority(role.getRoleName())).toList();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.allRoles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.name;
	}

}
