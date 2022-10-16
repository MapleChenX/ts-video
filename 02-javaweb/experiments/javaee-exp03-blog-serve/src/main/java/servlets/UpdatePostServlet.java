package servlets;

import configs.MySQLConfig;
import entities.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DateTimeFormatter;
import utils.JdbcOperation;
import utils.ParseReqBody;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "UpdatePost", urlPatterns = {"/update/post"})
public class UpdatePostServlet extends HttpServlet {

  private static final JdbcOperation<Post> op = new JdbcOperation<>(MySQLConfig.class, Post.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Post post = (Post) ParseReqBody.get(req, Post.class);
    post.setPostDate(new Date());
    op.load(post).update();
    op.close();
  }
}
