package com.system.student.mapper;

import com.system.student.entity.union.UniCourseStu;
import com.system.student.entity.union.UniTchCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {

  List<UniCourseStu> queryTchStuCourse(Map<String, Object> map);

  Integer updateStuCourseScore(Map<String, Object> map);

  List<UniTchCourse> queryTchCourse(Map<String, Object> map);
}
