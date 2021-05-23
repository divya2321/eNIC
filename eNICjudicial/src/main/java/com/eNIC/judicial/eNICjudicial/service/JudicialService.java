package com.eNIC.judicial.eNICjudicial.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import com.eNIC.judicial.eNICjudicial.entity.CommonCriminalRecord;

@Service
public class JudicialService {

	@Value("${user.token}")
	private String token;
	
	public  ResponseEntity<CommonCriminalRecord> saveRecord(CommonCriminalRecord commonCriminalRecord) {
		
		final String uri = "http://localhost:8081/api/judicial/save";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

		HttpEntity<Object> entity = new HttpEntity<Object>(commonCriminalRecord,headers);
	    
		 RestTemplate restTemplate = new RestTemplate();

	    ResponseEntity<CommonCriminalRecord> criminalRecordEntity = restTemplate.exchange(uri, HttpMethod.POST, entity, CommonCriminalRecord.class);
	    
	    return criminalRecordEntity;
	}
	
	
	
	public  Map<String, Object> searchCriminalRecords(String nic) throws RestClientException, URISyntaxException {
		final String uri = "http://localhost:8081/api/judicial/viewbynic?nicno="+nic;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
	    
		 RestTemplate restTemplate = new RestTemplate();
		 
		  ResponseEntity<Map> response = restTemplate.exchange(uri, HttpMethod.GET, entity, Map.class);
		  
		  Map<String, Object> criminalRecords = response.getBody();
		 
	    return criminalRecords;
	}
	
	
	
}
