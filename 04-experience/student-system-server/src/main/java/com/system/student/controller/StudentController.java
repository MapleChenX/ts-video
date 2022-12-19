package com.system.student.controller;

import com.system.student.entity.union.UniActivity;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniScore;
import com.system.student.entity.union.UniStudent;
import com.system.student.service.StudentService;
import com.system.student.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/stu")
public class StudentController {

  private final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @PostMapping("/query/self")
  public UniStudent querySelf(@RequestBody Map<String, Object> map) {
    return service.querySelf(map);
  }

  @PostMapping("/update/self")
  public Result updateSelf(@RequestBody Map<String, Object> map) {
    return service.updateSelf(map);
  }

  /**
   * 查询学生的课程相关信息
   * <p>
   * sno  学号，查询该学号的课程
   * term 学期，查询该学期的课程
   */
  @PostMapping("/query/courses")
  public List<UniCourse> queryCoursesSeries(@RequestBody Map<String, Object> map) {
    return service.queryCoursesSeries(map);
  }

  /**
   * 查询学生课程成绩相关信息
   * <p>
   * sno  学号，查询该学号的课程成绩
   * term 学期，查询该学期的课程成绩
   * less 成绩，查询成绩小于等于 less 的课程
   * more 成绩，查询成绩大于等于 more 的课程
   */
  @PostMapping("/query/scores")
  public List<UniScore> queryScoresSeries(@RequestBody Map<String, Object> map) {
    return service.queryScoresSeries(map);
  }

  /**
   * 查询学生活动相关信息
   * <p>
   * sno   学号，查询该学号的活动
   * type  活动类型：素拓、义工
   * genre 活动性质：公益劳动、比赛竞赛
   * term  学期，查询该学期的活动
   * less  分数，查询小于等于 less 的活动
   * more  分数，查询大于等于 more 的活动
   */
  @PostMapping("/query/acts")
  public List<UniActivity> queryActsSeries(@RequestBody Map<String, Object> map) {
    return service.queryActsSeries(map);
  }

}
