package com.nleitefaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.domain.AddressDTO;
import com.nleitefaria.domain.ProductDTO;
import com.nleitefaria.model.Address;
import com.nleitefaria.model.Product;
import com.nleitefaria.service.AddressService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class AddressController 
{
	@Autowired
	AddressService addressService;
	
	@Operation(summary = "Get all addresses")
	@GetMapping("/api/v1/addresses")
	public ResponseEntity<List<AddressDTO>> findAll()
	{
		return new ResponseEntity<List<AddressDTO>>(addressService.findAll(), HttpStatus.OK);	
	}
	
	@Operation(summary = "Create a address")
	@PostMapping("/api/v1/address")
	public ResponseEntity<Address> save(@RequestBody AddressDTO addressDTO) 
	{
		Address address = addressService.save(addressDTO);		
		if(address != null)
		{
			return new ResponseEntity<Address>(addressService.save(addressDTO), HttpStatus.CREATED);		
		}
		else
		{
			return new ResponseEntity<Address>(addressService.save(addressDTO), HttpStatus.BAD_REQUEST);
		}	  
	}

}
