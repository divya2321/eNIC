package com.eNIC.health.eNIChealth.service;

import java.net.URISyntaxException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.eNIC.health.eNIChealth.entity.CommonHealthRecord;

@Service
public class HealthService {

	@Value("${user.token}")
	private String token;
	
	public  ResponseEntity<CommonHealthRecord> saveRecord(CommonHealthRecord commonHealthRecord) {
		
		final String uri = "http://localhost:8081/api/health/save";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

		HttpEntity<Object> entity = new HttpEntity<Object>(commonHealthRecord,headers);
	    
		 RestTemplate restTemplate = new RestTemplate();

		 ResponseEntity<CommonHealthRecord> healthRecordEntity = restTemplate.exchange(uri, HttpMethod.POST, entity, CommonHealthRecord.class);
	    
	    return healthRecordEntity;
	}
	
	public  ResponseEntity<CommonHealthRecord> saveBloodType(CommonHealthRecord commonHealthRecord) {
		
		final String uri = "http://localhost:8081/api/health/saveblood";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

		HttpEntity<Object> entity = new HttpEntity<Object>(commonHealthRecord,headers);
	    
		 RestTemplate restTemplate = new RestTemplate();

		 ResponseEntity<CommonHealthRecord> healthRecordEntity = restTemplate.exchange(uri, HttpMethod.PUT, entity, CommonHealthRecord.class);
	    
	    return healthRecordEntity;
	}
	
	
	
	public  Map<String, Object> searchHealthRecords(String nic) throws RestClientException, URISyntaxException {
		final String uri = "http://localhost:8081/api/health/viewbynic?nicno="+nic;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
	    
		 RestTemplate restTemplate = new RestTemplate();
		 
		  ResponseEntity<Map> response = restTemplate.exchange(uri, HttpMethod.GET, entity, Map.class);
		  
		  Map<String, Object> healthRecords = response.getBody();
		 
	    return healthRecords;
	}
	
	
	
}
