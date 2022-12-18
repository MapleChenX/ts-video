package com.system.student.entity.union;

import com.system.student.entity.Course;
import com.system.student.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniCourse {

  private Course course;
  private Teacher teacher;

}
