package com.nuvu.api.services;

import com.nuvu.api.models.JwtResponse;
import com.nuvu.api.models.UserModel;

public interface IUserService {
	
	UserModel findByUsername(String username);

	boolean existsByUsername(String username);
	
	JwtResponse signin(UserModel model);

}
