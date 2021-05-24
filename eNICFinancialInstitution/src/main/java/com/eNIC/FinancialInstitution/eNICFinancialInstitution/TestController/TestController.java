package com.eNIC.FinancialInstitution.eNICFinancialInstitution.TestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	
	@GetMapping("/hello")
	public String greeting() {
		return "search_person";
	}
}
