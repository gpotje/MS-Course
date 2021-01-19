package com.gpotdesevo.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.gpotdesevo.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId,int  day ) {
		return new Payment("Bob",200.0,day);
		
	}
}
