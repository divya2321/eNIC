package com.eNIC.services.eNICservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eNIC.services.eNICservices.entity.CommonService;
import com.eNIC.services.eNICservices.services.ServiceServices;

@Controller
@RequestMapping("/drp/org")
public class ServicesController {

	@Autowired
	private ServiceServices serviceServ;
	
	@PostMapping(value = "/registerorg")
	public String registerOrganization(@ModelAttribute("orgModel") CommonService orgDetail)throws Exception {
		
		CommonService orgDet = serviceServ.registerService(orgDetail);
		if (orgDet==null) {
			throw new Exception("The data are not saved properly");
		}
		return "redirect:/drp/org/login";
	} 
	
	@GetMapping(value = "/registration")
	public String viewRegistration(Model model) {
		
		CommonService orgDetail = new CommonService();
		model.addAttribute("orgModel", orgDetail);
		return "service/register_service";
		
	}
	
	@GetMapping(value = "/login")
	public String viewLogin(Model model) {
		
		return "service/login";
		
	}
	
	
}
