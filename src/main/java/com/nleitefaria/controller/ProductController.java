package com.nleitefaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.domain.ProductDTO;
import com.nleitefaria.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/api/v1/products")
	public ResponseEntity<List<ProductDTO>> findAll()
	{
		return new ResponseEntity<List<ProductDTO>>(productService.findAll(), HttpStatus.OK);	
	}

}
