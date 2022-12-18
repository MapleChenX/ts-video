package com.system.student.service;


import com.system.student.entity.Student;
import com.system.student.mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentMapper mapper;

  public StudentService(StudentMapper mapper) {
    this.mapper = mapper;
  }

  public Student querySelf(int sno) {
    Student student = new Student();
    student.setSno(sno);
    return mapper.queryMyself(student);
  }

}
