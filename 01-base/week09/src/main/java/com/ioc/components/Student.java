package com.ioc.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

  @Autowired
  private Teacher teacher;

  public void say() {
    System.out.println("Student => Hello!");
    teacher.say();
  }

}
