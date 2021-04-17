package com.nuvu.api.repository;

import java.util.Optional;

import com.nuvu.api.models.UserModel;


public interface IUserRepository {

	Optional<UserModel> findByUsername(String userName);

	Boolean existsByUsername(String username);

}
