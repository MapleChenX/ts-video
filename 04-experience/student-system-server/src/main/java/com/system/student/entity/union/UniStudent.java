package com.system.student.entity.union;

import com.system.student.entity.College;
import com.system.student.entity.Grade;
import com.system.student.entity.Profession;
import com.system.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniStudent {

  private Student student;
  private College college;
  private Profession profession;
  private Grade grade;

}
