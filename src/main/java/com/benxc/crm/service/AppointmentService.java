package com.benxc.crm.service;

import java.util.List;

import com.benxc.crm.entity.Appointment;

public interface AppointmentService {

	public List<Appointment> findAll();
	
	public Appointment findById(int theId);
	
	public void save(Appointment theEmployee);
	
	public void deleteById(int theId);

	public List<Appointment> searchBy(String theName);
	
}
