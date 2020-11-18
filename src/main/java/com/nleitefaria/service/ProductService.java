package com.nleitefaria.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nleitefaria.domain.ProductDTO;
import com.nleitefaria.model.Product;
import com.nleitefaria.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductDTO> findAll() 
	{
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();		
		for(Product product : productRepository.findAll())
		{
			ProductDTO productDTO = new ProductDTO(product.getId(), product.getSku(), product.getName(), product.getPrice());			
			productDTOList.add(productDTO);
		}			
		return productDTOList;
	}
	
	@Transactional
	public Product save(ProductDTO productDTO)
	{
		Product product = new Product(productDTO.getSku(), productDTO.getName(), productDTO.getPrice());		
		return productRepository.save(product);
	}
}
