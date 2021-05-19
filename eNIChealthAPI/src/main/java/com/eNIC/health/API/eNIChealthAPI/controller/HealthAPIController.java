package com.eNIC.health.API.eNIChealthAPI.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eNIC.health.API.eNIChealthAPI.entity.BloodType;
import com.eNIC.health.API.eNIChealthAPI.entity.CommonHealthRecord;
import com.eNIC.health.API.eNIChealthAPI.service.HealthService;



@RestController
@RequestMapping("/api/health")
public class HealthAPIController {

	@Autowired
	HealthService healthService;
	
	@PostMapping(value = "/save")
	public CommonHealthRecord saveHealthRecord(@RequestBody CommonHealthRecord commonHealthRecord) throws Exception{
		
		System.out.println(commonHealthRecord.getHealthRecord());
		CommonHealthRecord hr = healthService.saveHealthRecord(commonHealthRecord);
		
		if (hr == null) {				
			throw new Exception();
		}
		return hr;		
	}
	
	@PutMapping(value = "/saveblood")
	public BloodType saveBloodType(String nic, String bld) {
		nic = "199752300001";
		bld = "O+";
		BloodType btp = healthService.saveBloodType("200011600001", "O+");
		return btp;
	}

	@GetMapping(value = "/viewbynic")
	public Map<String, Object> getPersonHealth(){
		System.out.println("Call");
		Map<String, Object> searchedHealth = healthService.viewHealthRecords("200011600001", "nicno");
		System.out.println(searchedHealth);
		if (searchedHealth.isEmpty()) {
//			throw new DFileNotFoundException("No criminal records under this NIC number");
		} 		
		return searchedHealth;
	}
	
	@GetMapping(value = "/viewbyfingerprint")
	public Map<String, Object> getPersonFHealth( ){
		System.out.println("Call");
		Map<String, Object> searchedHealth = healthService.viewHealthRecords("200270200001", "fingerprint");
		if (searchedHealth.isEmpty()) {
//			throw new DFileNotFoundException("No criminal records under this fingerprint");
		} 	
		return searchedHealth;
	}
	
}
