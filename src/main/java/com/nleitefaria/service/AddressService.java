package com.nleitefaria.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nleitefaria.domain.AddressDTO;
import com.nleitefaria.model.Address;
import com.nleitefaria.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<AddressDTO> findAll()
	{
		List<AddressDTO> addressDTOList = new ArrayList<AddressDTO>();	
		AddressDTO addressDTO;
		for(Address address : addressRepository.findAll())
		{
			addressDTO = new AddressDTO(address.getId(), address.getStreet(), address.getPostalCode());
			addressDTOList.add(addressDTO);
		}			
		return addressDTOList;
	}
	
	@Transactional
	public Address save(AddressDTO addressDTO)
	{
		Address address = new Address(addressDTO.getStreet(), addressDTO.getPostalCode());
		return addressRepository.save(address);
	}

}
