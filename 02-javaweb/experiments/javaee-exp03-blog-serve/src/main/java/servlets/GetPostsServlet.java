package servlets;

import configs.MySQLConfig;
import entities.Post;
import entities.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JdbcOperation;
import utils.ParseReqBody;

import java.io.IOException;

@WebServlet(name = "GetPosts", urlPatterns = {"/get/posts"})
public class GetPostsServlet extends HttpServlet {
  private static final JdbcOperation<Post> op = new JdbcOperation<>(MySQLConfig.class, Post.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    User user = (User) ParseReqBody.get(req, User.class);
    resp.getWriter().write(op.load(new Post()).select(true, "user_id = " + user.getId()).getJson());
    op.close();
  }
}
