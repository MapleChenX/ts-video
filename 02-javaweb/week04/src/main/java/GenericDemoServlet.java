import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "generic_demo_servlet", urlPatterns = {"/generic_servlet"})
public class GenericDemoServlet extends GenericServlet {

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    servletResponse.setContentType("text/html;charset=utf-8");
    PrintWriter writer = servletResponse.getWriter();
    writer.print("<html><body>GenericDemo</body></html>");
  }
}
