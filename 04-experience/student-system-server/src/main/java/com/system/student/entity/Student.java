package com.system.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  private int sno;
  private int sex;
  private String phone;
  private String avatar;
  private String qq;
  private String email;
  private int age;
  private String indenti;
  private String stuType;
  private String examType;
  private String homeAddr;
  private String nation;
  private String birthday;
  private String nowAddr;
  private String bankNo;
  private String bankName;
  private String password;
  private String createDate;
  private String loginDate;
  private String name;

  private College college;
  private Profession profession;
  private Grade grade;

}
