package stage02.configs;

import stage02.annotations.DataConfigure;

@DataConfigure(
  url = "jdbc:sqlserver://localhost:1433;databaseName=db;integratedSecurity=false;",
  username = "root",
  password = "123123"
)
public class SqlServerConfig extends Config {
}
