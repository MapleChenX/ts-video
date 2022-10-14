package configs;

import annotations.DatabaseConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
