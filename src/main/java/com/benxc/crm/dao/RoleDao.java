package com.benxc.crm.dao;

import com.benxc.crm.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
