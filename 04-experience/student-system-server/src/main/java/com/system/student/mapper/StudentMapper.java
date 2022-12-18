package com.system.student.mapper;

import com.system.student.entity.Student;
import com.system.student.entity.union.UniCourse;
import com.system.student.entity.union.UniStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

  UniStudent queryMyself(Student student);

  List<UniCourse> queryMyCourses(Student student);

}
