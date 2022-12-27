package com.example.springsecurityexample.all;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/login")
	public String getlogin() {
		return "login";
	}

}
