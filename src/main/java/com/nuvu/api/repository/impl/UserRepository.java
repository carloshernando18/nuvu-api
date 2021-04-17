package com.nuvu.api.repository.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nuvu.api.models.UserModel;
import com.nuvu.api.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {
	
	private List<UserModel> users = Arrays.asList(new UserModel("admin","$2a$10$VU/FfVoHcYQ6fbCJkx87/u2MedwMYCw/AINaIL5uhYMr5SGXAPoEe"), new UserModel("invitado","$2a$10$thZ0Rk.c6S4seBITlS9K1u3jBPXMCOxNdEUXz7xY1zA/Bd8/L.t5O"));

	@Override
	public Optional<UserModel> findByUsername(String userName) {		
		return users.stream().filter(u -> u.getUsername().equals(userName)).findFirst();
	}

	@Override
	public Boolean existsByUsername(String userName) {
		return users.stream().anyMatch(u -> u.getUsername().equals(userName));
	}

}
