package com.system.student.mapper;

import com.system.student.entity.Student;
import com.system.student.entity.union.UniActivity;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniScore;
import com.system.student.entity.union.UniStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

  UniStudent querySelf(Map<String, Object> map);

  Integer updateSelf(Map<String, Object> map);

  List<UniCourse> queryCoursesSeries(Map<String, Object> map);

  List<UniScore> queryScoresSeries(Map<String, Object> map);

  List<UniActivity> queryActsSeries(Map<String, Object> map);

}
