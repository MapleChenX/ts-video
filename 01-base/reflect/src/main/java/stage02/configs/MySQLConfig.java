package stage02.configs;

import stage02.annotations.DataConfigure;

@DataConfigure(url = "jdbc:mysql://localhost:3306/javaweb", username = "root", password = "enziandom")
public class MySQLConfig extends Config {
}
