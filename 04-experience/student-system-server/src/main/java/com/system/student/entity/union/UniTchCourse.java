package com.system.student.entity.union;

import com.system.student.entity.Course;
import com.system.student.entity.Grade;
import com.system.student.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniTchCourse {

  private String term;
  private Course course;
  private Teacher teacher;
  private Grade grade;

}
