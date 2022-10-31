package stage01;

import entities.Customer;

import java.util.List;

public interface CustomerMapper {

  public List<Customer> selectAll();

  public List<Customer> selectByUsername(String username);

  public int addCustomer(Customer customer);

  public int deleteCustomerById(Integer id);

}
