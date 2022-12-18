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
    return mapper.querySelf(student);
  }

  public List<UniCourse> queryCoursesSeries(Integer sno, String term) {
    Map<String, Object> map = new HashMap<>();
    map.put("sno", sno);
    map.put("term", term);
    return mapper.queryCoursesSeries(map);
  }

  public List<UniScore> queryScoresSeries(Integer sno, String term) {
    Map<String, Object> map = new HashMap<>();
    map.put("sno", sno);
    map.put("term", term);
    return mapper.queryScoresSeries(map);
  }

  public List<UniActivity> queryActivitiesSeries(Integer sno, Integer type, Integer genre) {
    Map<String, Object> map = new HashMap<>();
    map.put("sno", sno);
    map.put("type", type);
    map.put("genre", genre);
    List<UniActivity> activities = mapper.queryActivitiesSeries(map);
    for (UniActivity activity : activities) {
      int sType = activity.getType();
      if (sType == ActivityType.YIGONG.getName()) {
        activity.setSType("义工");
      } else if (sType == ActivityType.SUTUO.getName()) {
        activity.setSType("素拓");
      }
      int sGenre = activity.getGenre();
      if (sGenre == ActivityGenre.GONGYI.getName()) {
        activity.setSGenre("公益劳动");
      } else if (sGenre == ActivityGenre.BISAI.getName()) {
        activity.setSGenre("比赛竞赛");
      }
    }
    return activities;
  }

}
