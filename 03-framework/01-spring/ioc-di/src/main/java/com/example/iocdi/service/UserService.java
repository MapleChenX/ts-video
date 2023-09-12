package com.example.iocdi.service;

import com.example.iocdi.pojo.User;
import com.example.iocdi.util.http.R;

import java.util.List;

/**
 * @description:
 * @package: com.example.iocdi.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface UserService {

    R<List<User>> getAll();

    R<User> getOne();

}
