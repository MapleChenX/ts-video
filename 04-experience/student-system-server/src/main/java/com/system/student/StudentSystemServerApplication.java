package com.system.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.system.student.mapper")
public class StudentSystemServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(StudentSystemServerApplication.class, args);
  }

}
