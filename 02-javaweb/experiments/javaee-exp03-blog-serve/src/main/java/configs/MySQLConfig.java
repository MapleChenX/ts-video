package configs;

import annotations.DatabaseConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MySQL 数据库连接配置类。使用注解 @DatabaseConfig 给类属性注入值。
 *
 * @author zhengrenfu
 * @version 1.0
 * @since 1.5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySQLConfig {
  @DatabaseConfig(name = "url", value = "jdbc:mysql://localhost:3306/javaweb")
  public String url;
  @DatabaseConfig(name = "username", value = "root")
  public String username;
  @DatabaseConfig(name = "password", value = "enziandom")
  public String password;
}
