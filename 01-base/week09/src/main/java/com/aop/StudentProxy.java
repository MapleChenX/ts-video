package com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class StudentProxy {

  @Before("execution(* com.aop.Student.say())")
  public void sayPlus() {
    System.out.println("This is a plus method.");
  }

}
