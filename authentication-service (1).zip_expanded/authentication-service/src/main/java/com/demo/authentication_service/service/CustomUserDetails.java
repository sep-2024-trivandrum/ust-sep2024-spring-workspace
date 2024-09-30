package com.demo.authentication_service.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.authentication_service.dao.entity.UserCredentialsEntity;

public class CustomUserDetails implements UserDetails {

	private String name;
	private String password;

	public CustomUserDetails(UserCredentialsEntity user) {
		this.name = user.getName();
		this.password = user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}
}
