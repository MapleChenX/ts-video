package stage02.configs;

import stage02.annotations.DataConfigure;

@DataConfigure(url = "jdbc:mysql://localhost:3306/db", username = "root", password = "123123")
public class MySQLConfig extends Config {
}
