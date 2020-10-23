package com.benxc.crm.dao;

import com.benxc.crm.entity.Users;

public interface UserDao {

    public Users findByUserName(String userName);
    
    public void save(Users user);
    
}
