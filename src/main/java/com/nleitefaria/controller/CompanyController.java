package com.nleitefaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.domain.CompanyDTO;
import com.nleitefaria.model.Company;
import com.nleitefaria.service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@Operation(summary = "Get all companies")
	@GetMapping("/api/v1/companies")
	public ResponseEntity<List<CompanyDTO>> findAll()
	{
		return new ResponseEntity<List<CompanyDTO>>(companyService.findAll(), HttpStatus.OK);	
	}
	
	@Operation(summary = "Create a company")
	@PostMapping("/api/v1/company")
	public ResponseEntity<Company> save(@RequestBody CompanyDTO companyDTO) 
	{
	    Company company = companyService.save(companyDTO);		
		if(company != null)
		{
			return new ResponseEntity<Company>(companyService.save(companyDTO), HttpStatus.CREATED);		
		}
		else
		{
			return new ResponseEntity<Company>(companyService.save(companyDTO), HttpStatus.BAD_REQUEST);
		}	  
	}
}
