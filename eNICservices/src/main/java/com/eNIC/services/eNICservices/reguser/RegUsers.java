package com.eNIC.services.eNICservices.reguser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class RegUsers {

	@GetMapping("/hello")
	public String getMap() {
		return "gov/service_requests";
	}
	
}
