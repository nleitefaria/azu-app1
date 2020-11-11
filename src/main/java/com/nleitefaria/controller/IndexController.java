package com.nleitefaria.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.model.Company;
import com.nleitefaria.repository.CompanyRepository;

@RestController
public class IndexController 
{
	@Autowired
	CompanyRepository companyRepository;
	
    @GetMapping("/")
	public ResponseEntity<Object> initDB() 
    {	
    	Company company1 = new Company();
		company1.setId(1);
		
		Company company2 = new Company();
		company2.setId(2);
		
		Company company3 = new Company();
		company3.setId(3);

		Company company4 = new Company();
		company4.setId(4);

		Company company5 = new Company();
		company5.setId(5);

		companyRepository.save(company1);
		companyRepository.save(company2);
		companyRepository.save(company3);
		companyRepository.save(company4);
		companyRepository.save(company5);
		
		URI uri;
		HttpHeaders httpHeaders = new HttpHeaders();
		try {
			uri = new URI("/swagger-ui.html");
			httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(uri);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);	
	}
}
