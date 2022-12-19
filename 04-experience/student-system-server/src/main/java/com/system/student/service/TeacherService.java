package com.system.student.service;

import com.system.student.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

  private final TeacherMapper mapper;

  public TeacherService(TeacherMapper mapper) {
    this.mapper = mapper;
  }


}
