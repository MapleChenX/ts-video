import java.sql.*;

public class UserProvider {

  private static final JdbcOperation pr = new JdbcOperation("jdbc:mysql://localhost:3306/javaweb", "root", "enziandom");

  public static void main(String[] args) throws SQLException {
    pr
      .insert("users", "name, password")
      .values("'enziandom', 'en123'")
      .combine()
      .executeUpdate();
    pr.close();
  }

}
