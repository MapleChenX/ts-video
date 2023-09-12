package com.example.iocdi.controller;

import com.example.iocdi.pojo.User;
import com.example.iocdi.service.UserService;
import com.example.iocdi.util.http.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @package: com.example.iocdi.controller
 * @author: zheng
 * @date: 2023/9/12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService service) {
        this.service = service;
    }

    @GetMapping("/get/all")
    public R<List<User>> getUserAll() {
        return service.getAll();
    }

    @GetMapping("/get/one")
    public R<User> getOne() {
        return service.getOne();
    }

}
