package com.gpotdesevo.hroauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpotdesevo.hroauth.entities.Users;
import com.gpotdesevo.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/search")
	public ResponseEntity<Users> findByEmail(@RequestParam String email){
		try {
		Users user = service.findByEmail(email);
		return ResponseEntity.ok(user);
		}
		catch(IllegalArgumentException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	

	@GetMapping(value = "/teste")
	public ResponseEntity<String> teste(){
		String t = "deu certo";
		return ResponseEntity.ok().body(t);
	}
	
		

}
