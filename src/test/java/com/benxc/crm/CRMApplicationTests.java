package com.benxc.crm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.benxc.crm.dao.UserDaoImpl;
import com.benxc.crm.dao.UserDao;
import com.benxc.crm.entity.Users;
import com.benxc.crm.service.UserService;
import com.benxc.crm.user.CrmUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRMApplicationTests {

	@Autowired
	private UserService service;
	
	@MockBean
	private UserDao userDao;
	
	@Test
	public void findByUserName() {
		String name="hhill";
		when(userDao.findByUserName(name)).thenReturn(new Users("hhill", "arst", 1, "Hank", "Hill", "hhill@hh.com"));
		assertEquals(name, service.findByUserName(name).getUserName());

	}
	
	// Refactor this
//	@Test
//	public void save() {
//		CrmUser user=new CrmUser();
//		doNothing().when(service.save(user)).thenReturn(user);
//		assertArrayEquals(user, service.save(user));
//
//	}

	
}

