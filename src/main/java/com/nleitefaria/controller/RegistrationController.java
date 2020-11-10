package com.nleitefaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController 
{
	@GetMapping("/api/v1/register/echo")
	public String echo() {
		return "@register - echo";
	}
	
	@GetMapping("/api/v1/register/hi")
	public String hi() {
		return "@register - hi";
	}
	
	@GetMapping("/api/v1/register/hello")
	public String hello() {
		return "@register - hello";
	}
	
}
