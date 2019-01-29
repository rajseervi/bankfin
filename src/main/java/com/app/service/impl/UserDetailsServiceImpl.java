package com.app.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserService service;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 
		// take login username and get DB Model class obj
		User user = service.getUserByEmail(username);
		Set<GrantedAuthority> roles = new HashSet<>();
		for (String role : user.getUserRole()) {
			roles.add(new SimpleGrantedAuthority(role));
		} 
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPwd(), roles);
	}

}
