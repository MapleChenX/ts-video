import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login_servlet_ver1", urlPatterns = {"/user_login_1"})
public class LoginServletVer1 extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    System.out.println("账号：" + username);
    System.out.println("密码：" + password);
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.print("<html><body>");
    if ("admin".equals(username) && "12345".equals(password)) {
      out.print("登录成功！欢迎您！" + username);
    } else {
      out.print("登陆失败");
    }
    out.print("</body></html>");
  }
}
