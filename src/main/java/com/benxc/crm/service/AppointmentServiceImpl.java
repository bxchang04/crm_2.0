package com.benxc.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benxc.crm.dao.AppointmentRepository;
import com.benxc.crm.entity.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentRepository appointmentRepository;
	
	@Autowired
	public AppointmentServiceImpl(AppointmentRepository theAppointmentRepository) {
		appointmentRepository = theAppointmentRepository;
	}
	
	@Override
	public List<Appointment> findAll() {
		return appointmentRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Appointment findById(int theId) {
		Optional<Appointment> result = appointmentRepository.findById(theId);
		
		Appointment theAppointment = null;
		
		if (result.isPresent()) {
			theAppointment = result.get();
		}
		else {
			// we didn't find the appointment
			throw new RuntimeException("Did not find appointment id - " + theId);
		}
		
		return theAppointment;
	}

	@Override
	public void save(Appointment theAppointment) {
		appointmentRepository.save(theAppointment);
	}

	@Override
	public void deleteById(int theId) {
		appointmentRepository.deleteById(theId);
	}

	@Override
	public List<Appointment> searchBy(String theName) {
		
		List<Appointment> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = appointmentRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}

}






