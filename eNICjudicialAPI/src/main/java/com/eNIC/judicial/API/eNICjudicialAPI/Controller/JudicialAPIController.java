package com.eNIC.judicial.API.eNICjudicialAPI.Controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eNIC.judicial.API.eNICjudicialAPI.Service.JudicialService;
import com.eNIC.judicial.API.eNICjudicialAPI.entity.CommonCriminalRecord;
import com.eNIC.judicial.API.eNICjudicialAPI.Exception.DFileNotFoundException;
import com.eNIC.judicial.API.eNICjudicialAPI.Exception.ResourceNotSavedException;



@RestController
@RequestMapping("/api/judicial")
public class JudicialAPIController {

	@Autowired
	JudicialService judService;
	
	@PostMapping(value = "/save")
	public CommonCriminalRecord saveCriminalRecord(@RequestBody CommonCriminalRecord commonCriminalRecord) throws Exception{
		
		System.out.println(commonCriminalRecord.getCriminalRecord());
		CommonCriminalRecord cr = judService.saveCriminalRecord(commonCriminalRecord);
		
		if (cr != null) {
			
			return cr;
		} else {
			throw new ResourceNotSavedException("The record not saved properly");
		}		
	}

	@GetMapping(value = "/viewbynic")
	public Map<String, Object> getPersonCrimes(){
		System.out.println("Call");
		Map<String, Object> searchedCrimes = judService.viewCriminalRecords("199712000001", "nicno");
		ArrayList<CommonCriminalRecord> cast = (ArrayList<CommonCriminalRecord>) searchedCrimes.get("Crimes");
	
		Date dt = cast.get(0).getRecordDate();
		System.out.println(dt);
		if (searchedCrimes.isEmpty()) {
			throw new DFileNotFoundException("No criminal records under this NIC number");
		} 		
		return searchedCrimes;
	}
	
	@GetMapping(value = "/viewbyfingerprint")
	public Map<String, Object> getFPersonCrimes( ){
		System.out.println("Call");
		Map<String, Object> searchedCrimes = judService.viewCriminalRecords("200270200001", "fingerprint");
		if (searchedCrimes.isEmpty()) {
			throw new DFileNotFoundException("No criminal records under this fingerprint");
		} 	
		return searchedCrimes;
	}
	
}
