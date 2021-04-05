package com.cc.CurrencyConvertor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControllwer {
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("message", "Hello World!");
		return "welcome";
	}
	
	@GetMapping("/hi")
	public String Hi() {
		
		return "hello";
	}
	
}
