package com.nleitefaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.model.Company;
import com.nleitefaria.repository.CompanyRepository;

@RestController
public class IndexController {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@GetMapping("/")
	public String initDB() {
		Company company1 = new Company();
		company1.setId(1);
		
		Company company2 = new Company();
		company2.setId(2);
		
		Company company3 = new Company();
		company3.setId(3);

		companyRepository.save(company1);
		companyRepository.save(company2);
		companyRepository.save(company3);	
		
		return "inited DB";
	}

}
