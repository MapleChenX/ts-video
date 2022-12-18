package com.system.student.service;

import com.system.student.entity.Student;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniStudent;
import com.system.student.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  private final StudentMapper mapper;

  public StudentService(StudentMapper mapper) {
    this.mapper = mapper;
  }

  public UniStudent querySelf(int sno) {
    Student student = new Student();
    student.setSno(sno);
    return mapper.queryMyself(student);
  }

  public List<UniCourse> queryMyCourses(int sno) {
    Student student = new Student();
    student.setSno(sno);
    return mapper.queryMyCourses(student);
  }

}
