package servlets;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
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
    User user = (User) ParseReqBody.get(req, User.class);
    JdbcOperation<User> operation = op.load(user).select(true, "username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'");
    List<User> users = operation.getObject();
    if (!users.isEmpty()) {
      User cookieUser = users.get(0);
      resp.addCookie(new Cookie("signed", String.valueOf(cookieUser.getId())));
    }
    resp.getWriter().write(operation.getJson());
    operation.close();
  }
}
