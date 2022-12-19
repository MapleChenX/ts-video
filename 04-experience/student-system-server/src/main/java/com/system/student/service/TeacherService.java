package com.system.student.service;

import com.system.student.entity.union.UniCourseStu;
import com.system.student.mapper.TeacherMapper;
import com.system.student.utils.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {

  private final TeacherMapper mapper;

  public TeacherService(TeacherMapper mapper) {
    this.mapper = mapper;
  }

  public List<UniCourseStu> queryStuCourse(String name, String term, String teacherId) {
    Map<String, Object> map = new HashMap<>();
    map.put("name", name);
    map.put("term", term);
    map.put("teacherId", teacherId);
    return mapper.queryStuCourse(map);
  }

  public Result updateStuCourseScore(
    Double score,
    Integer sno,
    Integer courseId,
    String term,
    Integer teacherId
  ) {
    Map<String, Object> map = new HashMap<>();
    map.put("score", score);
    map.put("sno", sno);
    map.put("courseId", courseId);
    map.put("term", term);
    map.put("teacherId", teacherId);
    System.out.println("score = " + score + ", sno = " + sno + ", courseId = " + courseId + ", term = " + term + ", teacherId = " + teacherId);
    Integer t = mapper.updateStuCourseScore(map);
    System.out.println(t);
    return new Result(200);
  }

}
