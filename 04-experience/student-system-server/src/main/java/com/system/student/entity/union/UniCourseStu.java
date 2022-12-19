package com.system.student.entity.union;

import com.system.student.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 联合查询实体类
 * <p>
 * 一个课程实体下的联合学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniCourseStu {

  private Integer stuId;
  private Integer courseId;
  private Integer teacherId;
  private UniStudent source;
  private Course course;
}
