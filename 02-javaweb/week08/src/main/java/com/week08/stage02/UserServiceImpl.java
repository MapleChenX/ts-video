package com.week08.stage02;

import com.week08.stage01.UserDao;

public class UserServiceImpl implements UserService {

  private UserDao dao;

  public void setDao(UserDao dao) {
    this.dao = dao;
  }

  @Override
  public void say() {
    dao.say();
    System.out.println("Hello World!");
  }

}
