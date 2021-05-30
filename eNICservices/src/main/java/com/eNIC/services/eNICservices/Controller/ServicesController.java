package com.eNIC.services.eNICservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eNIC.services.eNICservices.entity.CommonService;
import com.eNIC.services.eNICservices.services.ServiceServices;
import com.eNIC.services.eNICservices.validation.OrgRegistrationValidator;

@Controller
@RequestMapping("/org")
public class ServicesController {

	@Autowired
	private ServiceServices serviceServ;
	
	@Autowired
	private OrgRegistrationValidator orgRegistrationValidator;
	
	
	@PostMapping(value = "/registerorg")
	public String registerOrganization(@ModelAttribute("orgModel") CommonService orgDetail, BindingResult bindingResult, Model theModel)throws Exception {
		
		orgRegistrationValidator.validate(orgDetail, bindingResult);

        if (bindingResult.hasErrors()) {
        	return "service/register_service";
        }
		
		CommonService orgDet = serviceServ.registerService(orgDetail);
		if (orgDet==null) {
			throw new Exception("The data are not saved properly");
		}
		return "redirect:/org/login";
	} 
	
	@GetMapping(value = "/registration")
	public String viewRegistration(Model model) {
		
		
		CommonService orgDetail = new CommonService();
		model.addAttribute("orgModel", orgDetail);
		return "service/register_service";
		
	}
	
	   @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	      
	        return "service/login";
	    }
	

	
}
