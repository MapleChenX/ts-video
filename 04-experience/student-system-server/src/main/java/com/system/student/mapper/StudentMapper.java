package com.system.student.mapper;

import com.system.student.entity.Student;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniScore;
import com.system.student.entity.union.UniStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

  UniStudent queryMyself(Student student);

  List<UniCourse> queryMyCourses(Student student);

  List<UniCourse> queryMyCoursesByTerm(Map<String, Object> map);

  List<UniScore> queryMyScores(Student student);

  List<UniScore> queryMyScoresByTerm(Map<String, Object> map);

}
