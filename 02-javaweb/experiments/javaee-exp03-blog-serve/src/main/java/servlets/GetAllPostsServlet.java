package servlets;

import configs.MySQLConfig;
import entities.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JdbcOperation;

import java.io.IOException;

@WebServlet(name = "GetAllPosts", urlPatterns = {"/get/all/posts"})
public class GetAllPostsServlet extends HttpServlet {

  private static final JdbcOperation<Post> op = new JdbcOperation<>(MySQLConfig.class, Post.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");
    op.load(new Post()).select(true, null, "order by create_date desc");
    resp.getWriter().write(op.getJson());
  }
}
