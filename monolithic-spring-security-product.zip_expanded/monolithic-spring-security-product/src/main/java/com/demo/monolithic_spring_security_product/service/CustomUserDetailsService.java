package com.demo.monolithic_spring_security_product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.monolithic_spring_security_product.dao.AuthUserDao;
import com.demo.monolithic_spring_security_product.entity.AuthUser;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	AuthUserDao authUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AuthUser> authUser = authUserDao.findByAuthUsername(username);
		System.out.println("service : " + authUser.get());
		// but we have return UserDetails and not AuthUser
		// so copy all AuthUser data into UserDetails instance
		return authUser
		.map((user)->new CustomUserDetails(user.getAuthUsername(), user.getAuthPassword(), user.getAllRoles()))
		.orElseThrow(()-> new UsernameNotFoundException(username + " not found"));

	}


}
