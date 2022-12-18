package com.system.student.service;

import com.system.student.entity.Student;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniScore;
import com.system.student.entity.union.UniStudent;
import com.system.student.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  public List<UniCourse> queryMyCoursesByTerm(int sno, String term) {
    Map<String, Object> map = new HashMap<>();
    map.put("sno", sno);
    map.put("term", term);
    return mapper.queryMyCoursesByTerm(map);
  }

  public List<UniScore> queryMyScores(int sno) {
    Student student = new Student();
    student.setSno(sno);
    return mapper.queryMyScores(student);
  }

  public List<UniScore> queryMyScoresByTerm(int sno, String term) {
    Map<String, Object> map = new HashMap<>();
    map.put("sno", sno);
    map.put("term", term);
    return mapper.queryMyScoresByTerm(map);
  }

}
