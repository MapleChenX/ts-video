package com.system.student.enums;

public enum ActivityType {

  YIGONG(1),
  SUTUO(2);

  private int name;

  ActivityType(int name) {
    this.name = name;
  }

  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }
}
