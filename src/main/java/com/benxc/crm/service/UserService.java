package com.benxc.crm.service;

import com.benxc.crm.entity.Users;
import com.benxc.crm.user.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public Users findByUserName(String userName);

	public void save(CrmUser crmUser);
}
