import stage01.annotations.Property;
import stage01.clzs.User;
import stage02.annotations.DataConfigure;
import stage02.configs.MySQLConfig;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


public class Main {
  private MySQLConfig config;

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println("密码：" + main.config.getPassword());
  }

  public Main() {
    loadConfig();
  }

  private void loadConfig() {
    try {
      Class<MySQLConfig> configClz = MySQLConfig.class;
      config = configClz.getDeclaredConstructor().newInstance();
      for (Field field : configClz.getDeclaredFields()) {
        field.setAccessible(true);
        field.set(config, field.getAnnotation(DataConfigure.class).value());
      }
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }
}
