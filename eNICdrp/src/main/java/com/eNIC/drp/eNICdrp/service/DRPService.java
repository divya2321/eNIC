package com.eNIC.drp.eNICdrp.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.eNIC.drp.eNICdrp.entity.DRPCommonEntity;

@Service
public class DRPService {

	
	public  ResponseEntity<DRPCommonEntity> saveNic(DRPCommonEntity dRPCommonEntity) {
		final String uri = "http://localhost:8081/api/drp/registerperson";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkcnAyMTIzIiwiZXhwIjoxNjIxNzMxMTQ1LCJpYXQiOjE2MjE3MTMxNDV9.VwgFEaOYGEmjGMr3Q0-3XiAVsWizExfzH2lj9k-l4Nnbj8xa4X-e8MRxJ-_p-Q3PPGjEL9uoR0fFCD8gAN5fEw");

		HttpEntity<Object> entity = new HttpEntity<Object>(dRPCommonEntity,headers);
	    
		 RestTemplate restTemplate = new RestTemplate();

	    ResponseEntity<DRPCommonEntity> theDRPCommonEntity = restTemplate.exchange(uri, HttpMethod.POST, entity, DRPCommonEntity.class);
	    
	    return theDRPCommonEntity;
	}
	
	public  List<DRPCommonEntity> findsAllNic() {
		final String uri = "http://localhost:8081/api/drp/findall";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkcnAyMTIzIiwiZXhwIjoxNjIxNzMxMTQ1LCJpYXQiOjE2MjE3MTMxNDV9.VwgFEaOYGEmjGMr3Q0-3XiAVsWizExfzH2lj9k-l4Nnbj8xa4X-e8MRxJ-_p-Q3PPGjEL9uoR0fFCD8gAN5fEw");

		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
	    
		 RestTemplate restTemplate = new RestTemplate();
		 
		  ResponseEntity<List> response = restTemplate.exchange(uri, HttpMethod.GET, entity, List.class);
		  
		  List<DRPCommonEntity> theDRPCommonEntities = response.getBody();
		 
	    return theDRPCommonEntities;
	}
	
	public  List<DRPCommonEntity> findsAllNicByNic(String nic) throws RestClientException, URISyntaxException {
		final String uri = "http://localhost:8081/api/drp/findbynic?nic="+nic;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkcnAyMTIzIiwiZXhwIjoxNjIxNzMxMTQ1LCJpYXQiOjE2MjE3MTMxNDV9.VwgFEaOYGEmjGMr3Q0-3XiAVsWizExfzH2lj9k-l4Nnbj8xa4X-e8MRxJ-_p-Q3PPGjEL9uoR0fFCD8gAN5fEw");

		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		
	    RestTemplate restTemplate = new RestTemplate();
	    
	    ResponseEntity<List> response = restTemplate.exchange(uri, HttpMethod.GET, entity, List.class);

	    List<DRPCommonEntity> theDRPCommonEntities = response.getBody();
	    
	    return theDRPCommonEntities;
	}
	
	
	
}
