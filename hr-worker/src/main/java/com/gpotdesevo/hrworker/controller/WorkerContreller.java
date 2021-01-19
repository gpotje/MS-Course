package com.gpotdesevo.hrworker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpotdesevo.hrworker.entityes.Worker;
import com.gpotdesevo.hrworker.repository.WorkerRepository;


@RestController
@RequestMapping(value = "/workers")
public class WorkerContreller {

	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Optional<Worker>> findById(@PathVariable("id") Long id){
		Optional<Worker> obj = workerRepository.findById(id);
		return ResponseEntity.ok(obj);
		
	}
	
	
}
