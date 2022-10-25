import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login_servlet_ver2", urlPatterns = {"/user_login_2"})
public class LoginServletVer2 extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    if ("admin".equals(username) && "12345".equals(password)) {
      req.setAttribute("username", username);
      req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
    } else {
      req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
  }
}
