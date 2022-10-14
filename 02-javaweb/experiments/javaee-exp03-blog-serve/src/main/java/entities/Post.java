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
@Table(name = "posts")
public class Post {
  @Field("id")
  private int id;
  @Field("title")
  private String title;
  @Field("content")
  private String content;
  @Field("desc")
  private String desc;
  @Field("post_date")
  private Date postDate;
  @Field("create_date")
  private Date createDate;
  @Field("views")
  private int views;
  @Field("thumbs")
  private int thumbs;
  @Field("user_id")
  private int userId;
}
