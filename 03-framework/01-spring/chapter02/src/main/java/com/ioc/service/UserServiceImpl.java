package com.ioc.service;

import com.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

  private UserDao dao;

  @Autowired
  public void setDao(UserDao dao) {
    this.dao = dao;
  }

//  @Resource(name = "userDao")
//  private UserDao dao;

  @Override
  public void say() {
    System.out.println("User Service => Hello!");
    dao.say();
  }

}
