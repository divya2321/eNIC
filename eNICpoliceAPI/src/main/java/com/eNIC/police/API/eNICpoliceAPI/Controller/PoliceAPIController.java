package com.eNIC.police.API.eNICpoliceAPI.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eNIC.police.API.eNICpoliceAPI.entity.CommonCriminalRecord;
import com.eNIC.police.API.eNICpoliceAPI.service.PoliceService;



@RestController
@RequestMapping("/api/police")
public class PoliceAPIController {

	@Autowired
	PoliceService policeService;
	
	
	@GetMapping(value = "/viewbynic")
	public Map<String, Object> getPersonCrimes(){
		System.out.println("Call");
		Map<String, Object> searchedCrimes = policeService.viewCriminalRecords("199712000001", "nicno");
		return searchedCrimes;
	}
	
	@GetMapping(value = "/viewbyfingerprint")
	public Map<String, Object> getPersonFCrimes(){
		System.out.println("Call");
		Map<String, Object> searchedCrimes = policeService.viewCriminalRecords("199712000001", "fingerprint");
		return searchedCrimes;
	}
	
}
