package stage03;

import java.util.Date;

public class User {
  private int id;
  private String username;
  private String password;
  private String sex;
  private String signature;
  private String avatar;
  private int age;
  private Date create_date;
  private int fans;
  private int follows;
  private String show_name;

  public User() {
  }

  public User(int id, String username, String password, String sex, String signature, String avatar, int age, Date create_date, int fans, int follows, String show_name) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.sex = sex;
    this.signature = signature;
    this.avatar = avatar;
    this.age = age;
    this.create_date = create_date;
    this.fans = fans;
    this.follows = follows;
    this.show_name = show_name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Date getCreate_date() {
    return create_date;
  }

  public void setCreate_date(Date create_date) {
    this.create_date = create_date;
  }

  public int getFans() {
    return fans;
  }

  public void setFans(int fans) {
    this.fans = fans;
  }

  public int getFollows() {
    return follows;
  }

  public void setFollows(int follows) {
    this.follows = follows;
  }

  public String getShow_name() {
    return show_name;
  }

  public void setShow_name(String show_name) {
    this.show_name = show_name;
  }

  @Override
  public String toString() {
    return "\nUser{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", sex='" + sex + '\'' +
      ", signature='" + signature + '\'' +
      ", avatar='" + avatar + '\'' +
      ", age=" + age +
      ", create_date=" + create_date +
      ", fans=" + fans +
      ", follows=" + follows +
      ", show_name='" + show_name + '\'' +
      "} \n";
  }
}