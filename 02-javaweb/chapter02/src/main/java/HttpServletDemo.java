import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "http_servlet_demo", urlPatterns = {"/http_servlet"})
public class HttpServletDemo extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.println("<html>");
    writer.println("<body><title>Hello Servlet</title>");
    writer.println("<h3 style='color: #00f'>Hello World!</h3>");
    writer.println("今天的日期是：" + LocalDate.now() + "<br>");
    writer.println("现在的时间是：" + LocalTime.now());
    writer.println("</body>");
    writer.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
