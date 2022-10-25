import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register_servlet", urlPatterns = {"/register.do"})
public class RegisterServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter writer = resp.getWriter();

    writer.println("<html><head>");
    writer.println("<title>" + "用户信息" + "</title></head>");
    writer.println("<body><h4>" + "用户信息" + "</h4>");
    String username = req.getParameter("username");
    writer.println("用户名：" + username);
    String password = req.getParameter("password");
    writer.println("密码：" + password);
    writer.println("性别：" + req.getParameter("sex"));
    writer.println("年龄：" + req.getParameter("age"));
    String[] hobbies = req.getParameterValues("hobby");
    writer.println("爱好：");
    if (hobbies != null) {
      for (String hobby : hobbies) {
        writer.println(hobby + "<br>");
      }
    }
    writer.println("学历：" + req.getParameter("education"));
    writer.println("邮箱地址：" + req.getParameter("email"));
    writer.println("简历：" + req.getParameter("resume"));
    writer.println("</body></html>");
  }
}