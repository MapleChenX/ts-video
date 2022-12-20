package com.system.student.mapper;

import com.system.student.entity.Student;
import com.system.student.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface EntriesMapper {

  Student stuLogin(Map<String, Object> map);

  Teacher tchLogin(Map<String, Object> map);

}
