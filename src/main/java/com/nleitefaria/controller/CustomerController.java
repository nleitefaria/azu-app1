package com.nleitefaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.domain.CustomerDTO;
import com.nleitefaria.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Operation(summary = "Get all customers")
	@GetMapping("/api/v1/customers")
	public ResponseEntity<List<CustomerDTO>> findAll()
	{
		return new ResponseEntity<List<CustomerDTO>>(customerService.findAll(), HttpStatus.OK);	
	}

}
