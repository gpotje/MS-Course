package com.gpotdesevo.hrpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpotdesevo.hrpayroll.entities.Payment;
import com.gpotdesevo.hrpayroll.service.PaymentService;

@RestController
@RequestMapping(value ="/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,
			@PathVariable Integer days){
		
	Payment payment =  paymentService.getPayment( workerId, days);
	
	return ResponseEntity.ok(payment);
		
		
	
		
	}
	@GetMapping(value = "/teste")
	public ResponseEntity<String> teste(){
		
	String testando ="deu certo boara para o proximo";
	
	return ResponseEntity.ok(testando);
	
	
	
	}
}
