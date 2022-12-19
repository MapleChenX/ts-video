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
   *
   * @param sno  学号，查询该学号的课程
   * @param term 学期，查询该学期的课程
   */
  @GetMapping("/query/courses")
  public List<UniCourse> queryCoursesSeries(
    @RequestParam(value = "sno", required = false) Integer sno,
    @RequestParam(value = "term", required = false) String term
  ) {
    return service.queryCoursesSeries(sno, term);
  }

  /**
   * 查询学生课程成绩相关信息
   *
   * @param sno  学号，查询该学号的课程成绩
   * @param term 学期，查询该学期的课程成绩
   * @param less 成绩，查询成绩小于等于 less 的课程
   * @param more 成绩，查询成绩大于等于 more 的课程
   */
  @GetMapping("/query/scores")
  public List<UniScore> queryScoresSeries(
    @RequestParam(value = "sno", required = false) Integer sno,
    @RequestParam(value = "term", required = false) String term,
    @RequestParam(value = "less", required = false) Integer less,
    @RequestParam(value = "more", required = false) Integer more
  ) {
    return service.queryScoresSeries(sno, term, less, more);
  }

  /**
   * 查询学生活动相关信息
   *
   * @param sno   学号，查询该学号的活动
   * @param type  活动类型：素拓、义工
   * @param genre 活动性质：公益劳动、比赛竞赛
   * @param term  学期，查询该学期的活动
   * @param less  分数，查询小于等于 less 的活动
   * @param more  分数，查询大于等于 more 的活动
   */
  @GetMapping("/query/acts")
  public List<UniActivity> queryActsSeries(
    @RequestParam(value = "sno", required = false) Integer sno,
    @RequestParam(value = "type", required = false) Integer type,
    @RequestParam(value = "genre", required = false) Integer genre,
    @RequestParam(value = "term", required = false) String term,
    @RequestParam(value = "less", required = false) Double less,
    @RequestParam(value = "more", required = false) Double more
  ) {
    return service.queryActsSeries(sno, type, genre, term, less, more);
  }

}
