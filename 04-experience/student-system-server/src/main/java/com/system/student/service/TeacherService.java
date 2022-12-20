package com.system.student.service;

import com.system.student.entity.union.UniCourseStu;
import com.system.student.entity.union.UniTchCourse;
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

  public List<UniCourseStu> queryTchStuCourse(Map<String, Object> map) {
    return mapper.queryTchStuCourse(map);
  }

  public List<UniTchCourse> queryTchCourse(Map<String, Object> map) {
    return mapper.queryTchCourse(map);
  }

  public Result updateStuCourseScore(Map<String, Object> map) {
    Integer code = mapper.updateStuCourseScore(map);
    Result result = new Result();
    if (code >= 1) {
      result.setCode(200);
    } else {
      result.setCode(500);
    }
    return result;
  }

}
