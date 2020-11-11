package com.nleitefaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.domain.CompanyDTO;
import com.nleitefaria.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/api/v1/companies")
	public ResponseEntity<List<CompanyDTO>> findAll()
	{
		return new ResponseEntity<List<CompanyDTO>>(companyService.findAll(), HttpStatus.OK);	
	}
}
