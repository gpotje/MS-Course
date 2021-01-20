package com.gpotdesevo.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpotdesevo.hrpayroll.entities.Payment;
import com.gpotdesevo.hrpayroll.entities.Worker;
import com.gpotdesevo.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	
	
	public Payment getPayment(long workerId,int  day ) {
	
	
		Worker worker = workerFeignClient.findById(workerId).getBody().get();
				
		return new Payment(worker.getName(),worker.getDailyIncome(),day);
		
	}
	
	

	/* 
	 * Abordagem usando o RestTEmplate;
	 * 
	 * 
	 * @Value("${hr-worker.host}")
		private String workerHost; 
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId,int  day ) {
		Map<String,String> uriVariables  = new HashMap<>();
		uriVariables.put("id","" +workerId);
		
		
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}",
				Worker.class,uriVariables);
		return new Payment(worker.getName(),worker.getDailyIncome(),day);
		
	}*/
	
	
	
}
