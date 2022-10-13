package entities;

import annotations.Field;
import annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
  @Field("id")
  private Integer id;
  @Field("name")
  private String username;
  @Field("password")
  private String password;
}
