package com.nleitefaria.domain;

public class AddressDTO 
{
	private Integer id;
	private String street;
	private String postalCode;
	
	public AddressDTO() {
		super();
	}

	public AddressDTO(Integer id, String street, String postalCode) {
		super();
		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
