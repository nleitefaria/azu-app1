package com.nleitefaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.model.Company;
import com.nleitefaria.repository.CompanyRepository;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@GetMapping("/api/v1/companies")
	public ResponseEntity<List<Company>> getAllCompanies()
	{
		return new ResponseEntity<List<Company>>(companyRepository.findAll(), HttpStatus.OK);	
	}
}
