import entities.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Stage03Test {

  SqlSession sqlSession;

  {
    try {
      sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void selectAll() {
    List<Customer> customers = sqlSession.selectList("stage03.CustomerMapper.selectAll");
    System.out.println(Arrays.toString(customers.toArray()));
  }

}
