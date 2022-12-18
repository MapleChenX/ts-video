package com.system.student.entity.union;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniActivity {

  private int stuId;
  private int actId;
  private double score;
  private String term;
  private String name;
  private String createDate;
  private int type;
  private int genre;
  private String sType;
  private String sGenre;

}
