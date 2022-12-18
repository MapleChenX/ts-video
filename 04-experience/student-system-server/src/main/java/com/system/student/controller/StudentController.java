package com.system.student.controller;

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

  /**
   * 查询学生的课程相关信息
   * <p>
   * 只传入 sno：查询该学生所有学期的课程
   * 只传入 term：查询所有该学期的课程
   * 传入 sno 和 term：查询该学生该学期的所有课程
   *
   * @param sno  学号
   * @param term 学期
   */
  @GetMapping("/query/courses")
  public List<UniCourse> queryCoursesSeries(
    @RequestParam(value = "sno", required = false) Integer sno,
    @RequestParam(value = "term", required = false) String term
  ) {
    return service.queryCoursesSeries(sno, term);
  }

  @GetMapping("/query/scores")
  public List<UniScore> queryScoresSeries(
    @RequestParam(value = "sno", required = false) Integer sno,
    @RequestParam(value = "term", required = false) String term
  ) {
    return service.queryScoresSeries(sno, term);
  }

  @GetMapping("/query/activities")
  public List<UniActivity> queryActivitiesSeries(
    @RequestParam(value = "sno", required = false) Integer sno,
    @RequestParam(value = "type", required = false) Integer type,
    @RequestParam(value = "genre", required = false) Integer genre
  ) {
    return service.queryActivitiesSeries(sno, type, genre);
  }

}
