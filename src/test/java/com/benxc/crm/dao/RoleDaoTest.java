//package com.benxc.crm.dao;
//
//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertSame;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import com.benxc.crm.dao.RoleDao;
//import com.benxc.crm.entity.Role;
//import com.benxc.crm.entity.Users;
//import com.benxc.crm.service.UserService;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RoleDaoTest {
//	
//	@MockBean
//	private RoleDao roleDao;
//	
//	@Test
//	public void findByUserName() {
//		String name="ROLE_EMPLOYEE";
//		
//		when(roleDao.findRoleByName(name)).thenReturn(new Role("ROLE_EMPLOYEE"));
//		assertSame(name, roleDao.findRoleByName(name).getName());
//
//	}
//}