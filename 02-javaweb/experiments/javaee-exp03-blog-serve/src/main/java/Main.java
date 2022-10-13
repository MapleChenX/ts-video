import entities.User;
import utils.JdbcOperation;

import java.util.List;

public class Main {
  public static final String url = "jdbc:mysql://localhost:3306/javaweb";
  public static final String user = "root";
  public static final String password = "enziandom";
  private static final JdbcOperation<User> op = new JdbcOperation<>(url, user, password, User.class);

  public static void main(String[] args) {
    User user = new User();
    user.setId(10000);
    List<User> list = op.load(user).select(true, null).getObject();
    for (User obj : list) {
      System.out.println(obj.toString());
    }
  }
}
