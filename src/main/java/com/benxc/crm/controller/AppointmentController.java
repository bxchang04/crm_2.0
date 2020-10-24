package com.benxc.crm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.benxc.crm.entity.Appointment;
import com.benxc.crm.service.AppointmentService;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

	private AppointmentService appointmentService;
	
	public AppointmentController(AppointmentService theAppointmentService) {
		appointmentService = theAppointmentService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listAppointments(Model theModel) {
		
		// get appointments from db
		List<Appointment> theAppointments = appointmentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("appointments", theAppointments);
		
		return "/appointments/list-appointments";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Appointment theAppointment = new Appointment();
		
		theModel.addAttribute("appointment", theAppointment);
		
		return "/appointments/appointment-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("appointmentId") int theId,
									Model theModel) {
		
		// get the appointment from the service
		Appointment theAppointment = appointmentService.findById(theId);
		
		// set appointment as a model attribute to pre-populate the form
		theModel.addAttribute("appointment", theAppointment);
		
		// send over to our form
		return "/appointments/appointment-form";			
	}
	
	
	@PostMapping("/save")
	public String saveAppointment(@ModelAttribute("appointment") Appointment theAppointment) {
		
		// save the appointment
		appointmentService.save(theAppointment);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/appointments/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("appointmentId") int theId) {
		
		// delete the appointment
		appointmentService.deleteById(theId);
		
		// redirect to /appointments/list
		return "redirect:/appointments/list";
		
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("appointmentName") String theName,
						 Model theModel) {
		
		// delete the appointment
		List<Appointment> theAppointments = appointmentService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("appointments", theAppointments);
		
		// send to /appointments/list
		return "/appointments/list-appointments";
		
	}
	
}


















