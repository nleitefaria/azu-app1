package com.nleitefaria.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nleitefaria.domain.CustomerDTO;
import com.nleitefaria.model.Customer;
import com.nleitefaria.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<CustomerDTO> findAll()
	{
		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		CustomerDTO customerDTO;
		for(Customer customer : customerRepository.findAll())
		{
			customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getBirthdate());			
			customerDTOList.add(customerDTO);
		}			
		return customerDTOList;
	}
	
	@Transactional
	public Customer save(CustomerDTO customerDTO)
	{
		Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getBirthdate());
		return customerRepository.save(customer);
	}

}
