package com.gpotdesevo.hrpayroll.feignclients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gpotdesevo.hrpayroll.entities.Worker;



@Component
@FeignClient(name = "hr-worker",path = "/workers")
public interface WorkerFeignClient {

	@GetMapping(value ="/{id}" )
	ResponseEntity<Optional<Worker>> findById(@PathVariable("id") Long id);
}
