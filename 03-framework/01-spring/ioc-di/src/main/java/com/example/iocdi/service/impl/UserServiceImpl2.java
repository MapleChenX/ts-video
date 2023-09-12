package com.example.iocdi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.iocdi.mapper.UserMapper;
import com.example.iocdi.pojo.User;
import com.example.iocdi.service.UserService;
import com.example.iocdi.util.http.R;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @package: com.example.iocdi.service.impl
 * @author: zheng
 * @date: 2023/9/12
 */
@Service("userServiceImpl2")
public class UserServiceImpl2 extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public R<List<User>> getAll() {
        return R.success("调用的是 UserServiceImpl2 的 getAll()", super.query().list());
    }

    @Override
    public R<User> getOne() {
        return R.success("调用的是 UserServiceImpl2 的 getOne()", super.query().one());
    }

}
