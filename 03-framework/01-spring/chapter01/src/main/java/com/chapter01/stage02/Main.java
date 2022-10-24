package com.chapter01.stage02;

import com.chapter01.stage03.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    User user = (User) context.getBean("user01");
    System.out.println(user.getList().toString());
  }

}
