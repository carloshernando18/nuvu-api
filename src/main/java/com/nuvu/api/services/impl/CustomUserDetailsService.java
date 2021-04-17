package com.nuvu.api.services.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nuvu.api.models.UserModel;
import com.nuvu.api.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final IUserRepository userRepository;

	/**
	 * Constructor.
	 *
	 * @param userRepository user repository.
	 */
	@Autowired
	public CustomUserDetailsService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) {
		Optional<UserModel> optionalUser = userRepository.findByUsername(userName);
		org.springframework.security.core.userdetails.User authUser = null;
		if (optionalUser.isPresent()) {
			UserModel user = optionalUser.get();

			authUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("The user or password are incorrect.");
		}
		return authUser;
	}

}
