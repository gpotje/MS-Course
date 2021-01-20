package com.gpotdesevo.hrpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpotdesevo.hrpayroll.entities.Payment;
import com.gpotdesevo.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value ="/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,
			@PathVariable Integer days){
		
	Payment payment =  paymentService.getPayment( workerId, days);
	
	return ResponseEntity.ok(payment);	
		
	}
	
	public ResponseEntity<Payment> getPaymentAlternative( Long workerId,Integer days){
		
		Payment payment =  new Payment("Brann", 400.0, days);
		
		return ResponseEntity.ok(payment);	
			
		
		
	}
	
	
	@GetMapping(value = "/teste")
	public ResponseEntity<String> teste(){
		
	String testando ="deu certo boara para o proximo";
	
	return ResponseEntity.ok(testando);
	
	
	
	}
}
