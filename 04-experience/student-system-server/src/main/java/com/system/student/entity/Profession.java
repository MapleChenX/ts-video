package com.system.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profession {

  private int pno;
  private String name;
  private String enName;
  private String type;
  private String eduSys;
  private String degree;
  private String intro;
  private String code;

}
