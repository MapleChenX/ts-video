package stage02;

import entities.Customer;

import java.util.List;

public interface CustomerMapper {

  public List<Customer> selectWhere(Customer customer);

}
