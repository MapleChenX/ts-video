# JavaEE 博客后端

基于 Servlet 实现的博客后端。前端与后端分离模式开发的博客系统，所以前端不包含在 webapp 内，也没有使用 JSP 技术。

本人通过注解以及反射机制封装了 JDBC 操作，目前只能支持单表查询，多表查询涉及更多的实体类和字段，实现起来比较复杂。并且，目的除了完成课程
作业以外，还是练习反射和注解。

> GitHub 地址：https://github.com/Enziandom/java-learning

# 包的介绍

## utils

该包内包含了重要的工具类，其中 JdbcOperation 和 ParseReqBody 两个类是最主要的工具类。

1. JdbcOperation：简化了 JDBC 的操作，去除了重复频繁的数据库连接、数据库配置、SQL 预编译等步骤。
2. ParseReBody：简化了 HTTP 消息实体获取的步骤，读取 req 的流，通过 fastjson2 构建一个实体类，类型是 Object，后续根据实际情况强转类型。

## filters

CrossOriginFilter：用来解决跨域问题，因为前后端分离的端口号不一样，不是同源。

## entities

这里存放所有需要用到的实体类。每一个实体类都需要用到 annotations 注解，用于解决 Java 字段驼峰命名法与 MySQL 字段冲突的问题。

## configs

MySQLConfig 配置类用于配置连接数据库所需要的基本信息，url、password、username 等，一次配置就不再需要在其他地方重复配置。

## annotations

注解是本项目非常重要的东西，它解决了各种配置烦恼，以及解决实体类与MySQL字段冲突的问题。