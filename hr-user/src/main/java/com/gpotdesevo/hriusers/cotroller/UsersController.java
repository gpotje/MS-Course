package com.gpotdesevo.hriusers.cotroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpotdesevo.hriusers.entities.Users;
import com.gpotdesevo.hriusers.repositorie.usersRepository;


@RestController
@RequestMapping(value = "/users")
public class UsersController {
	
	
	@Autowired
	private usersRepository repository;
	
	
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Optional<Users>> findById(@PathVariable("id") Long id){
		
		Optional<Users> obj = repository.findById(id);
		return ResponseEntity.ok(obj);
		
	}
	@GetMapping(value ="/search" )
	public ResponseEntity<Users> findByEmail(@RequestParam String email){
		
		Users obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
		
	}
	

}
