import stage02.annotations.DataConfigure;
import stage02.configs.Config;
import stage02.configs.MySQLConfig;
import stage02.configs.SqlServerConfig;

import java.lang.reflect.InvocationTargetException;


public class Main<T extends Config> {

  private final T config;

  public static void main(String[] args) {
    Main<MySQLConfig> mysql = new Main<>(MySQLConfig.class);
    Main<SqlServerConfig> sqlServer = new Main<>(SqlServerConfig.class);
    System.out.println(mysql.config.toString());
    System.out.println(sqlServer.config.toString());
  }

  public Main(Class<T> clz) {
    try {
      config = clz.getDeclaredConstructor().newInstance();
      DataConfigure annotation = clz.getAnnotation(DataConfigure.class);
      config.setPassword(annotation.password());
      config.setUsername(annotation.username());
      config.setUrl(annotation.url());
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

}
