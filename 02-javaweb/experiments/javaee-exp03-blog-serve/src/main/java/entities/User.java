package entities;

import annotations.Field;
import annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
  @Field("id")
  private int id;
  @Field("username")
  private String username;
  @Field("password")
  private String password;
  @Field("sex")
  private String sex;
  @Field("signature")
  private String signature;
  @Field("avatar")
  private String avatar;
  @Field("age")
  private int age;
  @Field("create_date")
  private Date createDate;
}
