package servlets;

import configs.MySQLConfig;
import entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JdbcOperation;
import utils.ParseReqBody;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
  private static final JdbcOperation<User> op = new JdbcOperation<>(MySQLConfig.class, User.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");
    User body = (User) ParseReqBody.get(req, User.class);
    op.load(body).select(true, "username = '" + body.getUsername() + "' and password = '" + body.getPassword() + "'");
    List<User> users = op.getList();
    if (!users.isEmpty()) {
      User user = users.get(0);
      Cookie cookie = new Cookie("signed", String.valueOf(user.getId()));
      cookie.setPath("/");
      cookie.setMaxAge(3600 * 24 * 7);
      resp.addCookie(cookie);
    }
    resp.getWriter().write(op.getJson());
    op.close();
  }
}
