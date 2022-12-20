package com.system.student.controller;

import com.system.student.entity.union.UniCourseStu;
import com.system.student.entity.union.UniTchCourse;
import com.system.student.service.TeacherService;
import com.system.student.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/tch")
public class TeacherController {

  private final TeacherService service;

  public TeacherController(TeacherService service) {
    this.service = service;
  }

  @PostMapping("/query/courses")
  public List<UniTchCourse> queryTchCourse(@RequestBody Map<String, Object> map) {
    return service.queryTchCourse(map);
  }

  @PostMapping("/query/stu/courses")
  public List<UniCourseStu> queryTchStuCourse(@RequestBody Map<String, Object> map) {
    return service.queryTchStuCourse(map);
  }

  @PostMapping("/update/course/score")
  public Result updateStuCourseScore(@RequestBody Map<String, Object> map) {
    return service.updateStuCourseScore(map);
  }

}
