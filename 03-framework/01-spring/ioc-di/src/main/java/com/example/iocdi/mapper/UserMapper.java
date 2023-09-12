package com.example.iocdi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.iocdi.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @package: com.example.iocdi.mapper
 * @author: zheng
 * @date: 2023/9/12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
