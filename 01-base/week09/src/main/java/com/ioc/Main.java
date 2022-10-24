package com.ioc;

import com.ioc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ioc/applicationContext.xml");
    UserService service = (UserService) ac.getBean("userService");
    service.say();
  }

}
