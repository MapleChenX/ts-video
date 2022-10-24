package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentProxy {

  @Before("execution(* com.aop.Student.*())")
  public void before() {
    System.out.println("Before => before methods...");
  }


  @After("execution(* com.aop.Student.*())")
  public void after() {
    System.out.println("After => after methods...");
  }

}
