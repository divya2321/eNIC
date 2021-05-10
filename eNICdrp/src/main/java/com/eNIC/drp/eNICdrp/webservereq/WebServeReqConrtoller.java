package com.eNIC.drp.eNICdrp.webservereq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebServeReqConrtoller {
	@GetMapping("/viewservereq")
	public String getMap() {
		return "viewNIC";
	}
}
