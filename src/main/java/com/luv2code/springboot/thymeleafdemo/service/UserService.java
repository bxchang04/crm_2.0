package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Users;
import com.luv2code.springboot.thymeleafdemo.user.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public Users findByUserName(String userName);

	public void save(CrmUser crmUser);
}
