package com.eNIC.services.eNICservices.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eNIC.services.eNICservices.services.EmailService;
import com.eNIC.services.eNICservices.services.ServiceServices;



@Controller
@RequestMapping("/drp/services")
public class DRPController {

	@Autowired
	private ServiceServices serviceServe;
	
	@Autowired
	EmailService emailServiceImpl;
	
	@GetMapping(value = "/view")
	public String viewServices(Model model) {
		model.addAttribute("allServices", serviceServe.getAllServices());
		return "gov/service_requests";		
	}

	@GetMapping(value = "/view/update")
	public String updateStatus(@RequestParam("oid") int oid, @RequestParam("ostatus") String ostatus) throws Exception {
		serviceServe.updateStatus(oid, ostatus);
		return "redirect:/drp/services/view";		
	}

	

}
