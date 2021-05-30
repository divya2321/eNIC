package com.eNIC.police.eNICpolice.controller;



import java.net.URISyntaxException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import com.eNIC.police.eNICpolice.service.PoliceService;

@Controller
@RequestMapping("/police")
public class PoliceController {

	@Autowired
	private PoliceService policeService;
	
	
	
	@GetMapping("/view/records")
	public String viewCriminalRecords(Model model) {
		return "view_criminals";
	}
	
	@GetMapping("/view/records/search")
	public String searchCriminalRecords(@RequestParam("nic")String nic, Model model) throws RestClientException, URISyntaxException {
		
		Map<String, Object> crminials = policeService.searchCriminalRecords(nic);
	
		model.addAttribute("crminials", crminials);
	
		return "view_criminals";
	
	}
	

	
}
