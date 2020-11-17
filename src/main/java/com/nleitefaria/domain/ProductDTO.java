package com.nleitefaria.domain;

public class ProductDTO {
	
	private Integer id;	
	private String sku ;
	private String name;
    private Double price;
    
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(String sku, String name, Double price) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
	}

	public ProductDTO(Integer id, String sku, String name, Double price) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
