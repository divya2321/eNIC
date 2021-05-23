package com.eNIC.health.API.eNIChealthAPI.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eNIC.health.API.eNIChealthAPI.config.JwtTokenUtil;
import com.eNIC.health.API.eNIChealthAPI.entity.CommonHealthRecord;
import com.eNIC.health.API.eNIChealthAPI.exception.DFileNotFoundException;
import com.eNIC.health.API.eNIChealthAPI.exception.ResourceNotSavedException;
import com.eNIC.health.API.eNIChealthAPI.service.HealthService;



@RestController
@RequestMapping("/api/health")
public class HealthAPIController {

	@Autowired
	private HealthService healthService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping(value = "/save", produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml"})
	public CommonHealthRecord saveHealthRecord(@RequestHeader(value = "Authorization") String authorization, @RequestBody CommonHealthRecord commonHealthRecord) throws Exception{
		
		String jwtToken = authorization.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
	
		commonHealthRecord.setUsername(username);
		CommonHealthRecord hr = healthService.saveHealthRecord(commonHealthRecord);
		
		
		if (hr == null) {				
			throw new DFileNotFoundException("No health records found");
		}
		return hr;		
	}
	
	@PutMapping(value = "/saveblood", produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml"})
	public CommonHealthRecord saveBloodType( @RequestBody CommonHealthRecord commonHealthRecord) {
		CommonHealthRecord btp = healthService.saveBloodType(commonHealthRecord);
		if (btp == null) {
			throw new ResourceNotSavedException("Error in saving blood type");
		}
		return btp;
	}

	@GetMapping(value = "/viewbynic", produces = { "application/json", "application/xml" })
	public Map<String, Object> getPersonHealth(@RequestParam("nicno") String nicno){
		
		Map<String, Object> searchedHealth = healthService.viewHealthRecords(nicno);
		System.out.println(searchedHealth);
		if (searchedHealth.isEmpty()) {
			throw new DFileNotFoundException("No health records under this NIC number");
		} 		
		return searchedHealth;
	}
	
	
	
}
