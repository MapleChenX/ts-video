import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import stage01.Customer;

import java.io.IOException;

public class Stage01Test {

  @org.junit.Test
  public void add() throws IOException {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    Customer customer = new Customer();
    customer.setUsername("cust04");
    customer.setPassword("123456");
    customer.setMobilephone("11111111111");
    customer.setSex("男");
    customer.setJobs("Java 中级工程师");
    customer.setEducation("本科");
    int rows = sqlSession.insert("stage01.CustomerMapper.addCustomer", customer);
    if (rows > 0) System.out.println("你已经成功插入数据，影响 " + rows + " 行。");
    else System.out.println("插入数据失败。");
    sqlSession.commit();
    sqlSession.close();
  }


}
