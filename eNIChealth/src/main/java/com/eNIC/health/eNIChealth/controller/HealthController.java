package com.eNIC.health.eNIChealth.controller;



import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;

import com.eNIC.health.eNIChealth.entity.CommonHealthRecord;
import com.eNIC.health.eNIChealth.service.HealthService;

@Controller
@RequestMapping("/health")
public class HealthController {

	@Autowired
	private HealthService healthService;
	
	@GetMapping("/add/record")
	public String viewAddRecord(Model model) {
		CommonHealthRecord commonEntity = new CommonHealthRecord();
		model.addAttribute("healthEntity",commonEntity);
		return "add_health_record";
	}

	@PostMapping(value = "/add/record/process")
	public String processAddRecord(@ModelAttribute("healthEntity") CommonHealthRecord commonHealthRecord, Model model)throws Exception {
		
	
		ResponseEntity<CommonHealthRecord> theResponseEntity =  healthService.saveRecord(commonHealthRecord);
		CommonHealthRecord commonEntity = new CommonHealthRecord();
		model.addAttribute("healthEntity",commonEntity);
		
		return "redirect:/health/add/record";
	
	
	} 
	
	@GetMapping("/view/records")
	public String viewCriminalRecords(Model model) {
		CommonHealthRecord commonEntity = new CommonHealthRecord();
		model.addAttribute("healthEntity",commonEntity);
		return "view_health_record";
	}
	
	@GetMapping("/view/records/search")
	public String searchCriminalRecords(@RequestParam("nic")String nic, Model model) throws RestClientException, URISyntaxException {
		
		Map<String, Object> health = healthService.searchHealthRecords(nic);
	
		model.addAttribute("health", health);
		
		CommonHealthRecord commonEntity = new CommonHealthRecord();
		model.addAttribute("healthEntity",commonEntity);
	
		return "view_health_record";
	
	}
	
	
	@PostMapping(value = "/add/blood/process")
	public String processAddBlood(@ModelAttribute("healthEntity") CommonHealthRecord commonHealthRecord, Model model)throws Exception {
		
	
		ResponseEntity<CommonHealthRecord> theResponseEntity =  healthService.saveBloodType(commonHealthRecord);

		Map<String, Object> health = healthService.searchHealthRecords(commonHealthRecord.getNicNo());
		
		model.addAttribute("health", health);
		
		CommonHealthRecord commonEntity = new CommonHealthRecord();
		model.addAttribute("healthEntity",commonEntity);
	
		return "redirect:/health/view/records/search?nic="+commonHealthRecord.getNicNo();
	
	
	} 

	
}
