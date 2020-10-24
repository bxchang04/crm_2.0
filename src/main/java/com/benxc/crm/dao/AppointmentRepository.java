package com.benxc.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benxc.crm.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	
	// add a method to sort by last name
	public List<Appointment> findAllByOrderByLastNameAsc();
	
	// search by name
	public List<Appointment> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
