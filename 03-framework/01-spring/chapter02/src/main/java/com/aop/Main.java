package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:aop/applicationContext.xml");
    Student student = (Student) ac.getBean("student");
    student.say();
  }

}
