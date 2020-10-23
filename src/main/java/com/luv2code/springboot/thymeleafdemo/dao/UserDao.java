package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Users;

public interface UserDao {

    public Users findByUserName(String userName);
    
    public void save(Users user);
    
}
