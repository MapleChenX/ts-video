package servlets;

import entities.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DbUtils;

import java.io.IOException;

@WebServlet(urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    DbUtils db = new DbUtils();
    Customer customer = new Customer();
    customer.setEducation(req.getParameter("education"));
    customer.setMobilephone(req.getParameter("mobilephone"));
    customer.setPassword(req.getParameter("password"));
    customer.setSex(req.getParameter("sex"));
    customer.setUsername(req.getParameter("username"));
    db.insert(customer);
    req.setAttribute("info", "注册成功");
    req.getRequestDispatcher("register.jsp").forward(req, resp);
  }
}
