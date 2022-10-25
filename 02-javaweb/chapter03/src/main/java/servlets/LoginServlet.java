package servlets;

import entities.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DbUtils;

import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    DbUtils db = new DbUtils();
    Customer customer = db.select(req.getParameter("username"), req.getParameter("password"));
    if (customer != null) {
      resp.sendRedirect("index.jsp");
    } else {
      req.setAttribute("error", "用户名或密码不正确");
      req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
  }
}
