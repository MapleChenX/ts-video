import entities.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Stage02Test {

  SqlSession sqlSession;

  {
    try {
      sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void selectWhere() {
    Customer customer = new Customer();
    customer.setUsername("cust");
    List<Customer> customers = sqlSession.selectList("stage02.CustomerMapper.selectWhere", customer);
    System.out.println(Arrays.toString(customers.toArray()));
    sqlSession.close();
  }

}
