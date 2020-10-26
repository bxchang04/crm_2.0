package com.benxc.crm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.benxc.crm.controller.CustomerController;
import com.benxc.crm.controller.EmployeeController;
import com.benxc.crm.dao.CustomerRepository;
import com.benxc.crm.dao.EmployeeRepository;
import com.benxc.crm.entity.Customer;
import com.benxc.crm.entity.Employee;
import com.benxc.crm.entity.Users;
import com.benxc.crm.service.CustomerService;
import com.benxc.crm.service.EmployeeService;

@SpringBootTest
public class CRMApplicationTests {

	@Autowired
	private EmployeeService service;

	@Autowired
	private CustomerService cservice;
	
	@MockBean
	private EmployeeRepository repository;

	@MockBean
	private CustomerRepository crepository;
	
	@Test
	public void findEmployeesTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee(100, "Hank", "Hill", "hhill@hh.com"), new Employee(101, "Hank2", "Hill2", "hhill2@hh.com")).collect(Collectors.toList()));
		assertEquals(2, repository.findAll().size());
	}

	@Test
	public void findEmployeeByIdTest() {
		Optional<Employee> newEmp = Optional.of(new Employee(100, "Hank", "Hill", "hhill@hh.com"));
		
		when(repository.findById(100)).thenReturn(newEmp);
		assertEquals(newEmp, repository.findById(100));
	}
	
//	@Test
//	public void DeleteEmployeeByIdTest() {
//		Optional<Employee> newEmp = Optional.of(new Employee(100, "Hank", "Hill", "hhill@hh.com"));
//		
//		when(repository.deleteById(100).doNothing());
//		assertEquals(true, repository.findById(100));
//	}
	
	@Test
	public void findCustomersTest() {
		when(crepository.findAll()).thenReturn(Stream
				.of(new Customer(100, "Harry", "Hill", "hhill@hh.com"), new Customer(101, "Harry2", "Hill2", "hhill2@hh.com")).collect(Collectors.toList()));
		assertEquals(2, crepository.findAll().size());
	}
	
	@Test
	public void findCustomerByIdTest() {
		Optional<Customer> newCust = Optional.of(new Customer(100, "Harry", "Hill", "hhill@hh.com"));
		
		when(crepository.findById(100)).thenReturn(newCust);
		assertEquals(newCust, crepository.findById(100));
	}


	
}

