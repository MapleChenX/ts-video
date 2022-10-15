package utils;

import java.text.SimpleDateFormat;

/**
 * 因为数据库的 Date 是 java.sql.Date，和平时用到的 java.util.Date 不一样。
 * 所以需要格式化 Java 中的 Date 为 yyyy-MM-dd HH:mm:ss 格式的日期，才能插入到数据库中保存。
 *
 * @author zhengrenfu
 * @version 1.0
 * @since 1.0
 */
public class DateTimeFormatter {
  public static String format(java.util.Date data) {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
  }
}
