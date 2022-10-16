package servlets;

import configs.MySQLConfig;
import entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JdbcOperation;
import utils.ParseReqBody;

import java.io.IOException;

@WebServlet(name = "GetUser", urlPatterns = {"/get/user"})
public class GetUserServlet extends HttpServlet {

  private static final JdbcOperation<User> op = new JdbcOperation<>(MySQLConfig.class, User.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");
    User body = (User) ParseReqBody.get(req, User.class);
    resp.getWriter().write(op.load(body).select(true, "id = " + body.getId()).getJson());
    op.close();
  }
}
