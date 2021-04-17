package com.nuvu.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nuvu.api.config.JwtUtils;
import com.nuvu.api.models.JwtResponse;
import com.nuvu.api.models.UserModel;
import com.nuvu.api.repository.IUserRepository;
import com.nuvu.api.services.IUserService;

@Service
public class UserService implements IUserService {

	private final IUserRepository userRepository;
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;

	@Autowired
	public UserService(IUserRepository userRepository, AuthenticationManager authenticationManager, JwtUtils jwtUtils, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.authenticationManager = authenticationManager;
		this.jwtUtils = jwtUtils;	
	}

	@Override
	public UserModel findByUsername(String username) {
		Optional<UserModel> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			UserModel model = new UserModel();
			model.setUsername(user.get().getUsername());
			return model;
		}
		return null;
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public JwtResponse signin(UserModel model) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(model.getUsername(), model.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtUtils.generateJwtToken(authentication);

		return new JwtResponse(token);
	}
}
