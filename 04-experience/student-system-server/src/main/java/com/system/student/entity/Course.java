package com.system.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

  private int cno;
  private String name;
  private String createDate;
  private String enName;
  private String range;
  private String property;
  private int credit;
  private String openUnit;
  private String intro;

}
