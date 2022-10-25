package entities;

public class Customer {

  private int id;
  private String username;
  private String password;
  private String sex;
  private String mobilephone;
  private String education;

  public Customer() {
  }

  public Customer(int id, String username, String password, String sex, String mobilephone, String education) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.sex = sex;
    this.mobilephone = mobilephone;
    this.education = education;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public void setMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getSex() {
    return sex;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getEducation() {
    return education;
  }
}
