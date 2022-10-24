package com.ioc.service;

import com.ioc.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

  @Resource(name = "userDao")
  private UserDao dao;

  @Override
  public void say() {
    System.out.println("User Service => Hello!");
    dao.say();
  }

}
