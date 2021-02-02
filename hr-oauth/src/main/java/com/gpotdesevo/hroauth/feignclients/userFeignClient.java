package com.gpotdesevo.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gpotdesevo.hroauth.entities.Users;

@Component
@FeignClient(name ="hr-users",path ="/users")
public interface userFeignClient {
	
	@GetMapping(value ="/search" )
	ResponseEntity<Users> findByEmail(@RequestParam String email);

}
