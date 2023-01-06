package com.marqueserick.incidentApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marqueserick.incidentApi.infra.exception.NotFoundException;
import com.marqueserick.incidentApi.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDetails> user = repository.findByUsername(username);
		if(user.isEmpty()) throw new NotFoundException("User not found");
		return user.get();
	}

}
