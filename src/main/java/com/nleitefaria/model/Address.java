package com.nleitefaria.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String street;
	
	private String postalCode;
	
	@OneToMany
    private List<Customer> customers;

	public Address() {
		super();
	}
	
	public Address(String street, String postalCode) {
		super();
		this.street = street;
		this.postalCode = postalCode;
	}
	
	public Address(Integer id, String street, String postalCode) {
		super();
		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
	}
	
	public Address(Integer id, String street, String postalCode, List<Customer> customers) {
		super();
		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
		this.customers = customers;
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

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}	
}
