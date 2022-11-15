package com.chapter01.stage02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("stage02/application.xml");
    UserService user = (UserService) context.getBean("userService");
    user.say();
  }

}
