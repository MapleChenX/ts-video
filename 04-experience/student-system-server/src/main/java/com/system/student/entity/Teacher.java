package com.system.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

  private int tno;
  private int sex;
  private String createDate;
  private String loginDate;
  private String phone;
  private String avatar;
  private String qq;
  private String email;
  private int age;
  private String indenti;
  private String homeAddr;
  private String nation;
  private String nowAddr;
  private String birthday;
  private String password;

}
