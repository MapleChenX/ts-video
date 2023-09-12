package com.example.iocdi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @description:
 * @package: com.example.iocdi.pojo
 * @author: zheng
 * @date: 2023/9/12
 */
@Data
@TableName("t_users")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Timestamp createDate;

    private Timestamp modifyDate;

}
