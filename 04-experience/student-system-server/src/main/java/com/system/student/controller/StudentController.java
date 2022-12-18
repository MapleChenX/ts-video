package com.system.student.controller;

import com.system.student.entity.Student;
import com.system.student.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class StudentController {

  private final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/query/self")
  public Student querySelf(@RequestParam("sno") int sno) {
    return service.querySelf(sno);
  }

}
