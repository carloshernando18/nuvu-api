package com.nuvu.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class DataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	private static final String PASSWORD = "qwerty";
	private static final String PASSWORD_2 = "123456";

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public DataLoader(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("===========================================");
		logger.info("paas_1: " + passwordEncoder.encode(PASSWORD));
		logger.info("paas_1: " + passwordEncoder.encode(PASSWORD_2));
		logger.info("===========================================");
	}

}
