import configs.MySQLConfig;
import entities.Post;
import utils.JdbcOperation;

public class Main {
  private static final JdbcOperation<Post> op = new JdbcOperation<>(MySQLConfig.class, Post.class);
  public static void main(String[] args) {
    op.load(new Post()).select(true, null).getJson();
  }
}
