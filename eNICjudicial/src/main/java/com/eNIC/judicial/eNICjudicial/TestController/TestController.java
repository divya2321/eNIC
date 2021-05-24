package com.eNIC.judicial.eNICjudicial.TestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/hello")
	public String greeting() {
		return "add_criminal";
	}
}
