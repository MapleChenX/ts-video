package com.system.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

  private int eno;
  private String name;
  private String createDate;
  private String type;
  private String genre;

}
