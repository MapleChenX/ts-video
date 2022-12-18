package com.system.student.controller;

import com.system.student.entity.Student;
import com.system.student.entity.union.UniActivity;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniScore;
import com.system.student.entity.union.UniStudent;
import com.system.student.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

  private final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/query/self")
  public UniStudent querySelf(@RequestParam("sno") int sno) {
    return service.querySelf(sno);
  }

  @GetMapping("/query/courses")
  public List<UniCourse> queryMyCourses(@RequestParam("sno") int sno) {
    return service.queryMyCourses(sno);
  }

  @GetMapping("/query/courses/by/term")
  public List<UniCourse> queryMyCoursesByTerm(@RequestParam("sno") int sno, @RequestParam("term") String term) {
    return service.queryMyCoursesByTerm(sno, term);
  }

  @GetMapping("/query/scores")
  public List<UniScore> queryMyScores(@RequestParam("sno") int sno) {
    return service.queryMyScores(sno);
  }

  @GetMapping("/query/scores/by/term")
  public List<UniScore> queryMyScoresByTerm(@RequestParam("sno") int sno, @RequestParam("term") String term) {
    return service.queryMyScoresByTerm(sno, term);
  }

  @GetMapping("/query/activities")
  public List<UniActivity> queryMyActivities(@RequestParam("sno") int sno) {
    return service.queryMyActivities(sno);
  }

}
