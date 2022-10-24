package com.ioc.components;

import org.springframework.stereotype.Component;

@Component
public class Teacher {

  public void say() {
    System.out.println("Teacher => Hello!");
  }

}
