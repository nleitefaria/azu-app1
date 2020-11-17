package com.nleitefaria.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nleitefaria.domain.CompanyDTO;
import com.nleitefaria.model.Company;
import com.nleitefaria.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	public List<CompanyDTO> findAll()
	{
		List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();		
		for(Company company : companyRepository.findAll())
		{
			CompanyDTO companyDTO= new CompanyDTO();
			companyDTO.setId(company.getId());
			
			companyDTOList.add(companyDTO);
		}			
		return companyDTOList;
	}
	
	@Transactional
	public Company save(CompanyDTO companyDTO)
	{
		Company company = new Company();
		company.setId(companyDTO.getId());
		return companyRepository.save(company);
	}

}
