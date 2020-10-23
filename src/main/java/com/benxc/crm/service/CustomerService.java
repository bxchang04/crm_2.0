package com.benxc.crm.service;

import java.util.List;

import com.benxc.crm.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theEmployee);
	
	public void deleteById(int theId);

	public List<Customer> searchBy(String theName);
	
}
