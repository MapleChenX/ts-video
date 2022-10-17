package stage02.configs;

import stage02.annotations.DataConfigure;

public class MySQLConfig {

  @DataConfigure("root")
  private String username;
  @DataConfigure("123123")
  private String password;
  @DataConfigure("jdbc:mysql://localhost:3306/db")
  private String url;

  @Override
  public String toString() {
    return "MySQLConfig{" +
      "username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", url='" + url + '\'' +
      '}';
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
