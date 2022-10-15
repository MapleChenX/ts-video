package utils;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 解析请求中 Body 消息。
 *
 * @author zhengrenfu
 * @version 1.0
 * @since 1.0
 */
public class ParseReqBody {
  public static Object get(HttpServletRequest request, Class<?> entity) throws IOException {
    BufferedReader reader = request.getReader();
    String line;
    StringBuilder builder = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      builder.append(line);
    }
    return JSON.parseObject(builder.toString(), entity);
  }
}
