package com.eNIC.judicial.eNICjudicial.controller;



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

import com.eNIC.judicial.eNICjudicial.entity.CommonCriminalRecord;
import com.eNIC.judicial.eNICjudicial.service.JudicialService;

@Controller
@RequestMapping("/judicial")
public class JudicialController {

	@Autowired
	JudicialService judicialService;
	
	@GetMapping("/add/record")
	public String viewAddRecord(Model model) {
		CommonCriminalRecord commonEntity = new CommonCriminalRecord();
		model.addAttribute("criminalEntity",commonEntity);
		return "add_criminal";
	}

	@PostMapping(value = "/add/record/process")
	public String processAddRecord(@ModelAttribute("criminalEntity") CommonCriminalRecord commonCriminalRecord, Model model)throws Exception {
		
	
		ResponseEntity<CommonCriminalRecord> theResponseEntity =  judicialService.saveRecord(commonCriminalRecord);
		CommonCriminalRecord commonEntity = new CommonCriminalRecord();
		model.addAttribute("criminalEntity",commonEntity);
		
		return "redirect:/judicial/add/record";
	
	
	} 
	
	@GetMapping("/view/records")
	public String viewCriminalRecords(Model model) {
		return "view_criminals";
	}
	
	@GetMapping("/view/records/search")
	public String searchCriminalRecords(@RequestParam("nic")String nic, Model model) throws RestClientException, URISyntaxException {
		
		Map<String, Object> crminials = judicialService.searchCriminalRecords(nic);
	
		model.addAttribute("crminials", crminials);
	
		return "view_criminals";
	
	}
	

	
}
