package utils;

import java.text.SimpleDateFormat;

public class DateTimeFormatter {
  public static String format(java.util.Date data) {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
  }
}
