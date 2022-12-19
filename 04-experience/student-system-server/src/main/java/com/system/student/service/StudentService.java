package com.system.student.service;

import com.system.student.entity.Student;
import com.system.student.entity.union.UniActivity;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniScore;
import com.system.student.entity.union.UniStudent;
import com.system.student.enums.ActivityGenre;
import com.system.student.enums.ActivityType;
import com.system.student.mapper.StudentMapper;
import com.system.student.utils.Result;
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

  public UniStudent querySelf(Map<String, Object> map) {
    return mapper.querySelf(map);
  }

  public Result updateSelf(Map<String, Object> map) {
    Result result = new Result();
    try {
      Integer code = mapper.updateSelf(map);
      if (code >= 0) {
        result.setCode(200);
      } else {
        result.setCode(500);
      }
    } catch (Exception e) {
      result.setCode(500);
    }
    return result;
  }

  public List<UniCourse> queryCoursesSeries(Map<String, Object> map) {
    return mapper.queryCoursesSeries(map);
  }

  public List<UniScore> queryScoresSeries(Map<String, Object> map) {
    return mapper.queryScoresSeries(map);
  }

  public List<UniActivity> queryActsSeries(Map<String, Object> map) {
    List<UniActivity> activities = mapper.queryActsSeries(map);
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
