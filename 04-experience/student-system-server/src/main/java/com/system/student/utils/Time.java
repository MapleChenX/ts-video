package com.system.student.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

  public static String format(Pattern pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern.getStyle());
    return sdf.format(new Date());
  }

  public enum Pattern {
    PATT_1("yyyy-MM-dd HH:mm:ss"),
    PATT_2("yyyy-MM-dd");

    private String style;

    Pattern(String style) {
      this.style = style;
    }

    public String getStyle() {
      return style;
    }

    public void setStyle(String style) {
      this.style = style;
    }
  }

}
