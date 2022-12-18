package com.system.student.enums;

public enum ActivityGenre {

  GONGYI(1),
  BISAI(2);

  private int name;

  ActivityGenre(int name) {
    this.name = name;
  }

  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }
}
