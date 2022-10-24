import java.sql.*;

/**
 * JDBC 操作类，拆分 SQL 代码，支持链式操作，简化在 Java 中写 SQL 代码的步骤。
 *
 * 静态块中加载 MySQL 驱动，只要 new 对象就不再执行这一步操作。
 */
public class JdbcOperation {

  private final String url;
  private final String user;
  private final String password;

  private Connection connection;

  private PreparedStatement preparedStatement;

  private ResultSet resultSet;

  private String sql;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public JdbcOperation(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public Connection getConnection() {
    return connection;
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  public PreparedStatement getPreparedStatement() {
    return preparedStatement;
  }

  public void setPreparedStatement(PreparedStatement preparedStatement) {
    this.preparedStatement = preparedStatement;
  }

  public ResultSet getResultSet() {
    return resultSet;
  }

  public void setResultSet(ResultSet resultSet) {
    this.resultSet = resultSet;
  }

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  public JdbcOperation select(String fields) throws SQLException {
    connection = DriverManager.getConnection(url, user, password);
    sql = "select " + fields;
    return this;
  }

  public JdbcOperation insert(String tableName, String fields) throws SQLException {
    connection = DriverManager.getConnection(url, user, password);
    sql = "insert into " + tableName + "(" + fields + ")";
    return this;
  }

  public JdbcOperation values(String values) {
    sql += " values(" + values + ")";
    return this;
  }

  public JdbcOperation update(String tableName) throws SQLException {
    connection = DriverManager.getConnection(url, user, password);
    sql = "update " + tableName;
    return this;
  }

  public JdbcOperation set(String sets) {
    sql += " set " + sets;
    return this;
  }

  public JdbcOperation delete(String tableName) throws SQLException {
    connection = DriverManager.getConnection(url, user, password);
    sql = "delete from " + tableName;
    return this;
  }

  public JdbcOperation from(String tableName) {
    sql += " from " + tableName;
    return this;
  }

  public JdbcOperation where(String condition) {
    sql += " where " + condition;
    return this;
  }

  public JdbcOperation combine() throws SQLException {
    preparedStatement = connection.prepareStatement(sql);
    return this;
  }

  public JdbcOperation cases(String[] strings) throws SQLException {
    for (int i = 0; i < strings.length; i++) {
      preparedStatement.setString(i + 1, strings[i]);
    }
    return this;
  }

  public int executeUpdate() throws SQLException {
    return preparedStatement.executeUpdate();
  }

  public void executeQuery() throws SQLException {
    setResultSet(preparedStatement.executeQuery());
  }

  public void close() {
    try {
      if (connection != null) connection.close();
      if (preparedStatement != null) preparedStatement.close();
      if (resultSet != null) resultSet.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
