package com.benxc.crm.dao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.benxc.crm.dao.RoleDao;
import com.benxc.crm.entity.Employee;
import com.benxc.crm.entity.Role;
import com.benxc.crm.entity.Users;
import com.benxc.crm.service.UserService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
	
	@MockBean
	private EmployeeRepository repo;
	
	@SuppressWarnings("unchecked")
	@Test
	// add a method to sort by last name
	public void findAllByOrderByLastNameAsc(){
		String name = "hank";
		String lname = "hill";
		Employee test = new Employee(1, name, lname, "hhill@gmail.com");
		when(((OngoingStubbing<List<Employee>>) repo.findAllByOrderByLastNameAsc()).thenReturn((List<Employee>) test));
		assertSame((List<Employee>)test, repo.findAllByOrderByLastNameAsc());

	};
	
	@SuppressWarnings("unchecked")
	@Test
	// search by name

	public void findByFirstNameContainsOrLastNameContainsAllIgnoreCase(){
		String name = "hank";
		String lname = "hill";
		Employee test = new Employee(1, name, lname, "hhill@gmail.com");
		when(repo.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, lname)).thenReturn((List<Employee>) test);
		assertSame((List<Employee>)test, repo.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, lname));

	};

}