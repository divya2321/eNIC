package com.eNIC.FinancialInstitution.eNICFinancialInstitution.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.eNIC.FinancialInstitution.eNICFinancialInstitution.entity.CommonGeneralDetail;

@Service
public class FinancialService {

	@Value("${user.token}")
	private String token;
	
	public  CommonGeneralDetail searchGeneralDetials(String nic) throws RestClientException {
		final String uri = "http://localhost:8081/api/finance/viewbynic?nicno="+nic;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
	    
		 RestTemplate restTemplate = new RestTemplate();
		 
		  ResponseEntity<CommonGeneralDetail> response = restTemplate.exchange(uri, HttpMethod.GET, entity, CommonGeneralDetail.class);
		  
		  CommonGeneralDetail criminalRecords = response.getBody();
		 
	    return criminalRecords;
	}
	
	
	
}
