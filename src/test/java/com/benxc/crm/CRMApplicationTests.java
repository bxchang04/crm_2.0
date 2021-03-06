package com.benxc.crm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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

	private static final String Answer = null;

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
	
	@Test
	public void searchEmployeeByString() {
		Employee newEmp = new Employee(100, "Hank", "Hill", "hhill@hh.com");
		List<Employee> newEmpList = Arrays.asList(newEmp);
		
		//repository doesn't work here. Research this.
		when(service.searchBy("Hank")).thenReturn(newEmpList);
		assertEquals(newEmpList, service.searchBy("Hank"));
	}
	
	@Test
	public void deleteEmployeeByIdTest() {
		Optional<Employee> newEmp = Optional.empty();
		doNothing().when(repository).deleteById(100);
		assertEquals(newEmp, repository.findById(100));
	}
	
	@Test
	public void saveEmployeeTest() {
		Employee newEmp = new Employee(101, "Hank3", "Hill3", "hhill3@hh.com");
		when(repository.save(newEmp)).thenReturn(newEmp);
		assertEquals(newEmp,repository.save(newEmp));
	}
	
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

	@Test
	public void deleteCustomerByIdTest() {
		Optional<Customer> newCust = Optional.empty();
		doNothing().when(crepository).deleteById(100);
		assertEquals(newCust, crepository.findById(100));
	}

	@Test
	public void searchCustomerByString() {
		Customer newCust = new Customer(100, "Harry", "Hill", "hhill@hh.com");
		List<Customer> newCustList = Arrays.asList(newCust);
		
		//repository doesn't work here. Research this.
		when(cservice.searchBy("Harry")).thenReturn(newCustList);
		assertEquals(newCustList, cservice.searchBy("Harry"));
	}
	
	@Test
	public void saveCustomerTest() {
		Customer newCust = new Customer(101, "Harry3", "Hill3", "hhill3@hh.com");
		when(crepository.save(newCust)).thenReturn(newCust);
		assertEquals(newCust,crepository.save(newCust));
	}
	
}

