package com.system.student.service;

import com.system.student.entity.Student;
import com.system.student.entity.union.UniActivity;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniScore;
import com.system.student.entity.union.UniStudent;
import com.system.student.enums.ActivityGenre;
import com.system.student.enums.ActivityType;
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

  public List<UniActivity> queryMyActivities(int sno) {
    Student student = new Student();
    student.setSno(sno);
    List<UniActivity> activities = mapper.queryMyActivities(student);
    for (UniActivity activity : activities) {
      int type = activity.getType();
      if (type == ActivityType.YIGONG.getName()) {
        activity.setSType("义工");
      } else if (type == ActivityType.SUTUO.getName()) {
        activity.setSType("素拓");
      }
      int genre = activity.getGenre();
      if (genre == ActivityGenre.GONGYI.getName()) {
        activity.setSGenre("公益劳动");
      } else if (genre == ActivityGenre.BISAI.getName()) {
        activity.setSGenre("比赛竞赛");
      }
    }
    return activities;
  }

}
