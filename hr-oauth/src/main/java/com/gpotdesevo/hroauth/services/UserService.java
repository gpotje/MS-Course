package com.gpotdesevo.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpotdesevo.hroauth.entities.Users;
import com.gpotdesevo.hroauth.feignclients.userFeignClient;


@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private userFeignClient userFeignClient;
	
	public Users findByEmail(String email) {
		Users user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			logger.error("Email not found:" + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found:" + email);
		return user;
	}
	
	
}
