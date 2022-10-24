package com.aop;

import org.springframework.stereotype.Component;

@Component
public class Student {

  public void say() {
    System.out.println("Student normal => Hello");
  }

}
