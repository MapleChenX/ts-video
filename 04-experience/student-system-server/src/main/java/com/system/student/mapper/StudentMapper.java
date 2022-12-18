package com.system.student.mapper;

import com.system.student.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

  Student queryMyself(Student student);

}
