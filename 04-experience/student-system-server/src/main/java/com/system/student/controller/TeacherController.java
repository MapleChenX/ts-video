package com.system.student.controller;

import com.system.student.entity.union.UniCourseStu;
import com.system.student.service.TeacherService;
import com.system.student.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tch")
public class TeacherController {

  private final TeacherService service;

  public TeacherController(TeacherService service) {
    this.service = service;
  }

  @GetMapping("/query/course")
  public List<UniCourseStu> queryStuCourse(
    @RequestParam(value = "name", required = false) String name,
    @RequestParam(value = "term", required = false) String term,
    @RequestParam(value = "teacherId", required = false) String teacherId
  ) {
    return service.queryStuCourse(name, term, teacherId);
  }

  @PostMapping("/update/course/score")
  public Result updateStuCourseScore(
    @RequestParam(value = "score", required = false) Double score,
    @RequestParam(value = "sno", required = false) Integer sno,
    @RequestParam(value = "teacherId", required = false) Integer teacherId,
    @RequestParam(value = "term", required = false) String term,
    @RequestParam(value = "courseId", required = false) Integer courseId
  ) {
    return service.updateStuCourseScore(score, sno, teacherId, term, courseId);
  }
}
