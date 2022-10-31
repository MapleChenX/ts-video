package stage01;

public class Customer {

  private int id;
  private String username;
  private String password;
  private String sex;
  private String mobilephone;
  private String education;
  private String jobs;

  public Customer() {
  }

  public Customer(int id, String username, String password, String sex, String mobilephone, String education, String jobs) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.sex = sex;
    this.mobilephone = mobilephone;
    this.education = education;
    this.jobs = jobs;
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

  public String getJobs() {
    return jobs;
  }

  public void setJobs(String jobs) {
    this.jobs = jobs;
  }

  @Override
  public String toString() {
    return "Customer{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", sex='" + sex + '\'' +
      ", mobilephone='" + mobilephone + '\'' +
      ", education='" + education + '\'' +
      ", jobs='" + jobs + '\'' +
      '}';
  }
}
