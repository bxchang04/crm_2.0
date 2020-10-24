package com.benxc.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benxc.crm.dao.AppointmentRepository;
import com.benxc.crm.entity.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentRepository AppointmentRepository;
	
	@Autowired
	public AppointmentServiceImpl(AppointmentRepository theAppointmentRepository) {
		AppointmentRepository = theAppointmentRepository;
	}
	
	@Override
	public List<Appointment> findAll() {
		return AppointmentRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Appointment findById(int theId) {
		Optional<Appointment> result = AppointmentRepository.findById(theId);
		
		Appointment theAppointment = null;
		
		if (result.isPresent()) {
			theAppointment = result.get();
		}
		else {
			// we didn't find the Appointment
			throw new RuntimeException("Did not find Appointment id - " + theId);
		}
		
		return theAppointment;
	}

	@Override
	public void save(Appointment theAppointment) {
		AppointmentRepository.save(theAppointment);
	}

	@Override
	public void deleteById(int theId) {
		AppointmentRepository.deleteById(theId);
	}

	@Override
	public List<Appointment> searchBy(String theName) {
		
		List<Appointment> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = AppointmentRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}

}






