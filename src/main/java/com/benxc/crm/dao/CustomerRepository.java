package com.benxc.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benxc.crm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	// add a method to sort by last name
	public List<Customer> findAllByOrderByLastNameAsc();
	
	// search by name
	public List<Customer> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
