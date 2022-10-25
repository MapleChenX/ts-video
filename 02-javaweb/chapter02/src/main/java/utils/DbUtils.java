package utils;

import entities.Customer;

import java.sql.*;

public class DbUtils {

  private Connection connection;
  private PreparedStatement ps;
  private ResultSet rs;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void connect() {
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "enziandom");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Customer select(String username, String password) {
    connect();
    Customer customer = null;
    try {
      ps = connection.prepareStatement("select * from t_customer where username = ? and password = ?");
      ps.setString(1, username);
      ps.setString(2, password);
      rs = ps.executeQuery();
      while (rs.next()) {
        customer = new Customer(
          rs.getInt("id"),
          rs.getString("username"),
          rs.getString("password"),
          rs.getString("sex"),
          rs.getString("mobilephone"),
          rs.getString("education")
        );
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    close();
    return customer;
  }

  public void insert(Customer customer) {
    connect();
    try {
      ps = connection.prepareStatement(
        "insert into t_customer(username, password, sex, mobilephone, education)" +
          " values(?,?,?,?,?)");
      ps.setString(1, customer.getUsername());
      ps.setString(2, customer.getPassword());
      ps.setString(3, customer.getSex());
      ps.setString(4, customer.getMobilephone());
      ps.setString(5, customer.getEducation());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    close();
  }

  public void update(Customer customer) {
    connect();
    try {
      ps = connection.prepareStatement(
        "update t_customer set username = ? set password = ? set sex ? set mobilephone = ? set education = ? where id = ?");
      ps.setString(1, customer.getUsername());
      ps.setString(2, customer.getPassword());
      ps.setString(3, customer.getSex());
      ps.setString(4, customer.getMobilephone());
      ps.setString(5, customer.getEducation());
      ps.setInt(6, customer.getId());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    close();
  }

  public void delete(int id) {
    connect();
    try {
      ps = connection.prepareStatement(
        "delete from t_customer where id = ?");
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    close();
  }

  public void close() {
    try {
      if (connection != null) connection.close();
      if (ps != null) ps.close();
      if (rs != null) rs.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
