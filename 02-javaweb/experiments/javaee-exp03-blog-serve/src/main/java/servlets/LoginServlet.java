package servlets;

import entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JdbcOperation;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
  public static final String url = "jdbc:mysql://localhost:3306/javaweb";
  public static final String user = "root";
  public static final String password = "enziandom";
  private static final JdbcOperation<User> op = new JdbcOperation<>(url, user, password, User.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    System.out.println(name);
    resp.setContentType("application/json");
    User user = new User();
    user.setId(0);
    user.setPassword("");
    String json = op.load(user).select(true, "name = '" + name + "'").getJson();
    resp.getWriter().write(json);
  }
}
