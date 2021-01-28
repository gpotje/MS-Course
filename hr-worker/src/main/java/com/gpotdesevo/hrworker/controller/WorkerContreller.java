package com.gpotdesevo.hrworker.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpotdesevo.hrworker.entityes.Worker;
import com.gpotdesevo.hrworker.repository.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerContreller {
		/*
	@Value("${test.config}")
	private String testConfig;
	*/
	
	@Autowired
	private Environment env;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerContreller.class);
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfig(){
		logger.info("CONFIG = " + env.getProperty("test.config"));
		//logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> list = workerRepository.findAll(); 
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Optional<Worker>> findById(@PathVariable("id") Long id){
		
		//logger.info("PORT = "+ env.getProperty("local.server.port"));
		Optional<Worker> obj = workerRepository.findById(id);
		return ResponseEntity.ok(obj);
		
	}
	
	
}
