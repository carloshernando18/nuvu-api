package com.nuvu.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.api.models.JwtResponse;
import com.nuvu.api.models.UserModel;
import com.nuvu.api.services.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final IUserService userService;

	@Autowired
	public AuthController(IUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody UserModel loginRequest) {
		return new ResponseEntity<>(userService.signin(loginRequest), HttpStatus.OK);
	}
	
}
