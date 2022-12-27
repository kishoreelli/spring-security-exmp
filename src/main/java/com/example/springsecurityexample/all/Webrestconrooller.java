package com.example.springsecurityexample.all;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Webrestconrooller {

	@GetMapping("/")
	public String gethome() {
		return "Hello Home";
	}
	
	@GetMapping("/user")
	public String getuser() {
		return "Hello user";
	}
	
	
	@GetMapping("/manager")
	public String getmanger() {
		return "Hello manager";
	}
	
	@GetMapping("/admin")
	public String getadmin() {
		return "Hello admin";
	}
}
