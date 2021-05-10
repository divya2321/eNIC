package com.eNIC.drp.eNICdrp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegController {

	@GetMapping("/hello")
	public String greeting() {
		return "view_nic_more";
	}
	
//	@GetMapping
	
}
