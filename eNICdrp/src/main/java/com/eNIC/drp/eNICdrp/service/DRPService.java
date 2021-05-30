package com.eNIC.drp.eNICdrp.service;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.eNIC.drp.eNICdrp.entity.DRPCommonEntity;
import com.eNIC.drp.eNICdrp.entity.UserAccount;

@Service
public class DRPService {

	@Value("${user.token}")
	private String token;
	
	public  ResponseEntity<DRPCommonEntity> saveNic(DRPCommonEntity dRPCommonEntity) {
		final String uri = "http://localhost:8081/api/drp/registerperson";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

		HttpEntity<Object> entity = new HttpEntity<Object>(dRPCommonEntity,headers);
	    
		 RestTemplate restTemplate = new RestTemplate();

	    ResponseEntity<DRPCommonEntity> theDRPCommonEntity = restTemplate.exchange(uri, HttpMethod.POST, entity, DRPCommonEntity.class);
	    
	    return theDRPCommonEntity;
	}
	
	public  List<DRPCommonEntity> findsAllNic() {
		final String uri = "http://localhost:8081/api/drp/findall";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

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
		headers.set("Authorization", token);

		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		
	    RestTemplate restTemplate = new RestTemplate();
	    
	    ResponseEntity<List> response = restTemplate.exchange(uri, HttpMethod.GET, entity, List.class);

	    List<DRPCommonEntity> theDRPCommonEntities = response.getBody();
	    
	    return theDRPCommonEntities;
	}
	
	public  String createUseraccount(UserAccount useraccount) throws RestClientException, URISyntaxException {
		final String uri = "http://localhost:8081/register";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);

		HttpEntity<Object> entity = new HttpEntity<Object>(useraccount,headers);
	    
		 RestTemplate restTemplate = new RestTemplate();

		 ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	    
	    return response.getBody();
	}
	
	
	
	
}
