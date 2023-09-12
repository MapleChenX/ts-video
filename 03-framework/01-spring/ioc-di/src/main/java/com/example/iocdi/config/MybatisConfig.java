package com.example.iocdi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @package: com.example.iocdi.config
 * @author: zheng
 * @date: 2023/9/12
 */
@Configuration
@MapperScan("com.example.iocdi.mapper")
public class MybatisConfig {

}
