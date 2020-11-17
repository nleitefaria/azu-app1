package com.nleitefaria.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.domain.CompanyDTO;
import com.nleitefaria.domain.ProductDTO;
import com.nleitefaria.service.CompanyService;
import com.nleitefaria.service.ProductService;

@RestController
public class IndexController 
{
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ProductService productService;
	
    @GetMapping("/")
	public ResponseEntity<Object> initDB() 
    {	
    	//////////////////////////////////////////////////////////////////////
    	CompanyDTO company1 = new CompanyDTO();
		company1.setId(1);
		
		CompanyDTO company2 = new CompanyDTO();
		company2.setId(2);
		
		CompanyDTO company3 = new CompanyDTO();
		company3.setId(3);

		CompanyDTO company4 = new CompanyDTO();
		company4.setId(4);

		CompanyDTO company5 = new CompanyDTO();
		company5.setId(5);

		companyService.save(company1);
		companyService.save(company2);
		companyService.save(company3);
		companyService.save(company4);
		companyService.save(company5);
		//////////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////////////////
		ProductDTO product1 = new ProductDTO("keyboard", "Keyboard", 7.99);
		ProductDTO product2 = new ProductDTO("tv", "Television", 351.96);	
		
		ProductDTO product3 = new ProductDTO("shirt", "Shirt", 3.57);		
		ProductDTO product4 = new ProductDTO("bed", "Bed", 131.00);		
				
		ProductDTO product5 = new ProductDTO("cell-phone", "Cell Phone", 1000.00);	
		ProductDTO product6 = new ProductDTO("spoon", "Spoon", 1.00);		
							
		productService.save(product1);
		productService.save(product2);	
		productService.save(product3);
		productService.save(product4);	
		productService.save(product5);
		productService.save(product6);
							
		//////////////////////////////////////////////////////////////////////
		
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
