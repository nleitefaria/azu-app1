package com.nleitefaria.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nleitefaria.service.InitService;

@RestController
public class IndexController 
{
	@Autowired
	InitService initService;
	
    @GetMapping("/")
	public ResponseEntity<Object> initDB() 
    {	
    	System.out.println("Initing DB");
    	initService.init();
    	System.out.println("Inited");
		
		URI uri;
		HttpHeaders httpHeaders = new HttpHeaders();
		try {
			uri = new URI("/swagger-ui/index.html");
			httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(uri);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);	
	}
}
